package org.pettyfox.tool.swagger2jsapi.java;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.pettyfox.tool.swagger2jsapi.MyFreemarker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @version 1.0
 * @date 2021/3/12 9:57
 */
@Slf4j
public class JavaGen {
    public void startGen(String jsonPath) throws IOException, TemplateException {
        String jsonStr = FileUtil.readString(new File(jsonPath), "UTF-8");
        JSONObject json = JSONObject.parseObject(jsonStr);
        json.getJSONObject("context").put("genDate", DateUtil.formatDateTime(new Date()));
        String workDir = getString(json, "context.workDir");
        if (json.containsKey("list")) {
            JSONArray list = json.getJSONArray("list");
            for (int i = 0; i < list.size(); i++) {
                json.put("cur", list.get(i));
                if(!getBool(json,"cur.enable")){
                    continue;
                }
                //build
                File voFile = joinPath(workDir, getString(json, "cur.vo.package"), getString(json, "cur.dao.name") + "Vo.java");
                log.info("gen vo:{}", voFile.getAbsolutePath());
                MyFreemarker.generate(json, voFile, new File("D:\\worklab-me\\swagger2-js-api\\src\\main\\resources\\templates\\java\\vo.ftl"));
                if(getBool(json,"cur.vo.pageVo")){
                    File pageVoFile = joinPath(workDir, getString(json, "cur.vo.package"), getString(json, "cur.dao.name") + "PageVo.java");
                    log.info("gen pageVo:{}", voFile.getAbsolutePath());
                    MyFreemarker.generate(json, pageVoFile, new File("D:\\worklab-me\\swagger2-js-api\\src\\main\\resources\\templates\\java\\page-vo.ftl"));

                }
                //build dao
                log.info("gen simple-dao");
                File simpleDaoFile = joinPath(workDir, getString(json, "cur.dao.package"), getString(json, "cur.dao.name") + "SimpleDao.java");
                MyFreemarker.generate(json, simpleDaoFile, new File("D:\\worklab-me\\swagger2-js-api\\src\\main\\resources\\templates\\java\\dao-simple.ftl"));
                log.info("gen complex-dao");
                File complexDaoFile = joinPath(workDir, getString(json, "cur.dao.package"), getString(json, "cur.dao.name") + "ComplexDao.java");
                MyFreemarker.generate(json, complexDaoFile, new File("D:\\worklab-me\\swagger2-js-api\\src\\main\\resources\\templates\\java\\dao-complex.ftl"));

                log.info("gen complex-dao impl");
                File complexDaoImplFile = joinPath(workDir, getString(json, "cur.dao.package")+".impl", getString(json, "cur.dao.name") + "ComplexDaoImpl.java");
                MyFreemarker.generate(json, complexDaoImplFile, new File("D:\\worklab-me\\swagger2-js-api\\src\\main\\resources\\templates\\java\\dao-complex-impl.ftl"));

                log.info("gen param");
                File paramFile = joinPath(workDir, getString(json, "cur.controller.package")+".params", getString(json, "cur.dao.name") + "EditParams.java");
                MyFreemarker.generate(json, paramFile, new File("D:\\worklab-me\\swagger2-js-api\\src\\main\\resources\\templates\\java\\edit-params.ftl"));

                log.info("gen param page");
                File paramPageFile = joinPath(workDir, getString(json, "cur.controller.package")+".params", getString(json, "cur.dao.name") + "PageParams.java");
                MyFreemarker.generate(json, paramPageFile, new File("D:\\worklab-me\\swagger2-js-api\\src\\main\\resources\\templates\\java\\page-params.ftl"));

                 log.info("gen biz");
                File bizFile = joinPath(workDir, getString(json, "cur.biz.package"), getString(json, "cur.dao.name") + "Biz.java");
                MyFreemarker.generate(json, bizFile, new File("D:\\worklab-me\\swagger2-js-api\\src\\main\\resources\\templates\\java\\biz.ftl"));

                log.info("gen biz impl");
                File bizImplFile = joinPath(workDir, getString(json, "cur.biz.package")+".impl", getString(json, "cur.dao.name") + "BizImpl.java");
                MyFreemarker.generate(json, bizImplFile, new File("D:\\worklab-me\\swagger2-js-api\\src\\main\\resources\\templates\\java\\biz-impl.ftl"));

                log.info("gen controller");
                File controllerFile = joinPath(workDir, getString(json, "cur.controller.package"), getString(json, "cur.dao.name") + "Controller.java");
                MyFreemarker.generate(json, controllerFile, new File("D:\\worklab-me\\swagger2-js-api\\src\\main\\resources\\templates\\java\\controller.ftl"));


            }
        }
    }

    private File joinPath(String workDir, String packageName, String name) {
        return Paths.get(Paths.get(workDir, packageName.split("\\.")).toFile().getAbsolutePath(), name).toFile();
    }

    private String getString(JSONObject json, String path) {
        String[] keys = path.split("\\.");
        JSONObject obj = json;
        for (int i = 0; i < keys.length; i++) {
            if (i + 1 == keys.length) {
                return obj.getString(keys[i]);
            } else {
                obj = obj.getJSONObject(keys[i]);
            }
        }
        return null;
    }
    private Boolean getBool(JSONObject json, String path) {
        String[] keys = path.split("\\.");
        JSONObject obj = json;
        for (int i = 0; i < keys.length; i++) {
            if (i + 1 == keys.length) {
                return obj.getBoolean(keys[i]);
            } else {
                obj = obj.getJSONObject(keys[i]);
            }
        }
        return null;
    }
}
