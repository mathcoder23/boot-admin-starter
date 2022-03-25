package org.pettyfox.tool.swagger2jsapi;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.pettyfox.tool.swagger2jsapi.bean.GenApi;
import org.pettyfox.tool.swagger2jsapi.bean.GenCmd;
import org.pettyfox.tool.swagger2jsapi.bean.GenRoot;
import org.pettyfox.tool.swagger2jsapi.bean.SwaggerRoot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 根据Swagger接口地址，生成前端js的接口对象文件集合
 *
 * @author Petty Fox
 * @version 1.0
 */
@Slf4j
public class Swagger2BuildJsApiImpl implements BuildJsApi {


    @Override
    public void startGen(String apiUrl, String pathFilter, GenRoot genRoot) {
        log.info("swagger api json url is : {}", apiUrl);
        String jsonApi = HttpUtil.get(apiUrl);
        log.info("json :{}", jsonApi);
        jsonApi = jsonApi.replaceAll("\\$ref", "ref");
        SwaggerRoot root = JSON.parseObject(jsonApi, SwaggerRoot.class);
        Set<String> pathList = filterPathList(pathFilter, root.getPaths().keySet());
        Map<String, Set<String>> group = groupPathList(pathList);
        List<GenApi> genApiList = new ArrayList<>();
        group.forEach((k, v) -> {
            GenApi genApi = new GenApi();
            genApi.setObjName(buildGenApiName(k));
            genApi.setUriPrefix(k);
            genApi.setCmdList(new ArrayList<>());
            genApi.setFilePath(k.substring(0, k.lastIndexOf("/")));
            int deep = k.split("/").length;
            StringBuffer sbDeep = new StringBuffer();
            for (int i = 0; i < deep - 2; i++) {
                sbDeep.append("../");
            }
            genApi.setImportCore(sbDeep.toString());

            v.forEach((path) -> {

                //接口方法
                root.getPaths().getJSONObject(path).keySet().forEach((method) -> {
                    JSONObject json = root.getPaths().getJSONObject(path).getJSONObject(method);
                    GenCmd genCmd = new GenCmd();

                    genCmd.setUri(path.substring(path.lastIndexOf("/") + 1));
                    genCmd.setCmdName("delete".equals(genCmd.getUri()) ? "remove" : genCmd.getUri());
                    genApi.getCmdList().add(genCmd);
                    genCmd.setApiMethod(toUpperCase4Index(method));
                    fillParam(genCmd, json, root);
                });

            });
            genApiList.add(genApi);
        });
        genRoot.setGenApiList(genApiList);
        log.info("swagger parse finish.");
        freemarkerParseBuild(genRoot);
        freemarkerParseBuildReport(genRoot);
        log.info("ok");
    }

    private void freemarkerParseBuild(GenRoot genRoot) {
        log.info("build file path:{}", genRoot.getGenRootFilePath());
        File templateFile = new File(genRoot.getTemplateFilePath());
        genRoot.getGenApiList().forEach(genApi -> {
            File outFile = Paths.get(genRoot.getGenRootFilePath(), genRoot.getModuleName(), genApi.getFilePath(), genApi.getObjName() + ".js").toFile();
            genRoot.setCGenApi(genApi);
            try {
                MyFreemarker.generate(
                        JSON.parseObject(JSON.toJSONString(genRoot)), outFile, templateFile
                );
            } catch (IOException | TemplateException e) {
                e.printStackTrace();
            }
        });

    }

    private void freemarkerParseBuildReport(GenRoot genRoot) {
        if (null == genRoot.getTemplateGenApiFilePath()) {
            return;
        }
        File templateFile = new File(genRoot.getTemplateGenApiFilePath());
        File outFile = Paths.get(genRoot.getGenRootFilePath(), "GenApi" + ".js").toFile();
        log.info("build GenApi file path:{}", outFile.getAbsolutePath());

        try {
            MyFreemarker.generate(
                    JSON.parseObject(JSON.toJSONString(genRoot)), outFile, templateFile
            );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    private void fillParam(GenCmd genCmd, JSONObject json, SwaggerRoot root) {
        JSONArray array = json.getJSONArray("parameters");
        JSONArray param = new JSONArray();
        if (null != array) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject item = array.getJSONObject(i);
                if ("body".equals(item.getString("in"))) {
                    String dPath = item.getJSONObject("schema").getString("ref");
                    String body = getDefinitions(root, dPath, 0);
                    genCmd.setBody(formatParam(body));
                } else if ("query".equals(item.getString("in"))) {
                    param.add(item);
                }
            }
        }

        if (null != json.getJSONObject("responses") && json.getJSONObject("responses").getJSONObject("200").containsKey("schema")) {
            genCmd.setResponse(formatParam(getDefinitions(root, json.getJSONObject("responses").getJSONObject("200").getJSONObject("schema").getString("ref"), 0)));
            genCmd.setResponseType("json");
        } else {
            genCmd.setResponseType("blob");
        }
        genCmd.setParams(formatParam(param.toString(SerializerFeature.PrettyFormat)));

    }

    private String formatParam(String param) {
        if (!StrUtil.isBlank(param)) {
            StringBuffer sb = new StringBuffer();
            for (String line : param.split("\n")) {
                sb.append("\t*").append(line).append("\n");
            }
            param = sb.toString();
        }
        return param;
    }

    private String getDefinitions(SwaggerRoot root, String dPath, int loop) {
        int floop = ++loop;
        if (floop > 2) {
            return null;
        }
        if (StrUtil.isBlank(dPath)) {
            return null;
        }
        dPath = dPath.replace("#/definitions/", "");
        JSONObject json = root.getDefinitions().getJSONObject(dPath);
        if (json.containsKey("properties")) {
            json.getJSONObject("properties").keySet().forEach(key -> {
                JSONObject item = json.getJSONObject("properties").getJSONObject(key);
                String ref = item.getString("ref");
                if (!StrUtil.isBlank(ref)) {
                    item.put("value", JSONObject.parseObject(getDefinitions(root, ref, floop)));
                }
            });
        }

        return json.toString(SerializerFeature.PrettyFormat);
    }

    /**
     * 过滤路径
     *
     * @param regFilter path的正则表达式
     * @param path      api路径
     * @return 正则匹配通过将返回true
     */
    private boolean filterPath(String regFilter, String path) {
        return ReUtil.isMatch(regFilter, path);
    }

    /**
     * 通过正则过滤数组，
     * 处理完成后悔修改路径集合中的内容
     *
     * @param regFilter path的正则表达式
     * @param paths     路径集合
     */
    private Set<String> filterPathList(String regFilter, Set<String> paths) {
        log.debug("start filter api paths,filter before count:{}", paths.size());
        Iterator<String> iterator = paths.iterator();
        while (iterator.hasNext()) {
            if (!filterPath(regFilter, iterator.next())) {
                iterator.remove();
            }
        }
        log.debug("end filter api paths,filter after count:{}", paths.size());
        return paths;
    }

    /**
     * 将路径分组
     * 路径以/分隔，最末端的变为元素，父级变为组
     *
     * @param paths 路径集合
     * @return 分组结果
     * /a/b/c
     * /a/b/d
     * /a/c/d
     * 结果
     * /a/b   /a/b/c /a/b/d
     * /a/c   /a/c/d
     */
    private Map<String, Set<String>> groupPathList(Set<String> paths) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String groupPath = path.substring(0, path.lastIndexOf("/"));
            if (StrUtil.isBlank(groupPath)) {
                groupPath = "default";
            }
            map.computeIfAbsent(groupPath, k -> new HashSet<>()).add(path);
        }
        return map;
    }

    /**
     * 将路径提取出接口名称
     *
     * @param path
     * @return
     */
    private String buildGenApiName(String path) {
        String result;
        if (path.lastIndexOf("/") >= 0) {
            result = path.substring(path.lastIndexOf("/") + 1);
        } else {
            result = path;
        }
        //横杠、下划线转驼峰
        return toUpperCase4Index(lineToHump(result) + "Api");
    }

    private static Pattern linePattern = Pattern.compile("[_-](\\w)");

    /**
     * 下划线转驼峰
     */
    public static String lineToHump(String str) {
//        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 首字母大写
     *
     * @param string
     * @return
     */
    public static String toUpperCase4Index(String string) {
        char[] methodName = string.toCharArray();
        methodName[0] = toUpperCase(methodName[0]);
        return String.valueOf(methodName);
    }

    /**
     * 字符转成大写
     *
     * @param chars
     * @return
     */
    public static char toUpperCase(char chars) {
        if (97 <= chars && chars <= 122) {
            chars ^= 32;
        }
        return chars;
    }
}
