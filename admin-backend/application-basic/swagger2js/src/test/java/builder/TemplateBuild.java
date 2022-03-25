package builder;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.pettyfox.tool.swagger2jsapi.Swagger2BuildJsApiImpl;
import org.pettyfox.tool.swagger2jsapi.bean.GenRoot;

/**
 * @author eface
 * @version 1.0
 * @date 2021/3/9 15:35
 */
@Slf4j
public class TemplateBuild {
    String api = "(/api/(?!commApi).*)";
    private static final String BUILD_DIR = "D:\\worklab\\ai-administer-platform-web\\src\\application\\api\\genApi";
    /**
     * swagger转js接口文件
     */
    @Test
    public void buildAPi() {

        String rootPath = System.getProperty("user.dir") + "/src/main";
        log.info("rootPath:{}", rootPath);
        GenRoot root = new GenRoot(BUILD_DIR
                , rootPath + "/resources/templates/PF-Swagger2Js-v2.ftl"
                , rootPath + "/resources/templates/PF-Swagger2Js-gen.ftl"
                , "", "Petty Fox");
        new Swagger2BuildJsApiImpl().startGen("http://127.0.0.1:9099/v2/api-docs", api, root);
    }

}
