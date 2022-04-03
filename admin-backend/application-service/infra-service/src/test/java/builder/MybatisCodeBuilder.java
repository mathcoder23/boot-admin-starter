package builder;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.pettyfox.base.comm.type.BaseEnum;
import org.pettyfox.base.web.dao.BaseTreeEntity;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Slf4j
public class MybatisCodeBuilder {
    private static final String MYSQL_URL = "jdbc:mysql://s8.pettyfox.com:11040/%s?useUnicode=true&useSSL=false&characterEncoding=utf8";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PWD = "Mysql...111";
    private static final String rootPath = Paths.get(System.getProperty("user.dir")).toFile().getPath();
    private static final String DB_NAME = "admin_db";
    private static final String TABLE_PREFIX = "t_m";
//    private static final String rootPath = Paths.get(System.getProperty("user.dir")).toFile().getPath();

    @Test
    public void buildPo() {
        //自定义字段类型转换
        TableFieldTypeConvert convert = (strategy, tableInfo) -> {
//            if (tableInfo.getName().equals("t_ai_data_dict")) {
//                tableInfo.getFields().forEach(tableField -> {
//                    if (tableField.getName().equals("field_config")) {
//                        TableFieldTypeConvert.convert(tableInfo, tableField, DataDictFiledConfig.class);
//                    }
//                });
//            }
        };
        build(
                ""
                , DB_NAME
                , "com.pettyfox.platform_example.business.domain"
                , convert
                , "t_m_test"
        );
        //生成树
//        buildTree(
//                ""
//                , DB_NAME
//                , "com.eface.platform.ai.administer.business.domain"
//                , convert
//                , "t_ai_area"
//        );
    }

    private void build(String modulesName, String dbName, String packagePath,
                       TableFieldTypeConvert convert,
                       String... tables) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(rootPath + "/src/main/java");
        gc.setAuthor("Petty Fox");
        gc.setOpen(false);
        gc.setSwagger2(false); //实体属性 Swagger2 注解
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(String.format(MYSQL_URL, dbName));
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(MYSQL_USER);
        dsc.setPassword(MYSQL_PWD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(modulesName);
        pc.setParent(packagePath);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("apiPrefix", "api");
                this.setMap(map);
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String filepath = rootPath + "/src/main/resources/repository/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                FileUtil.mkParentDirs(filepath);
                return filepath;
            }
        });
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                checkDir(filePath);
                if (!new File(filePath).exists()) {
                    return true;
                }
                if (FileType.ENTITY.equals(fileType)) {
                    // 允许生成模板文件
                    log.info("重新生成entity：{}", filePath);
                    return true;
                } else {
                    return false;
                }

            }
        });


        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
//        templateConfig.setController("/controller.java");

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(TABLE_PREFIX);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("org.pettyfox.base.web.dao.BaseEntitySnowId");
        strategy.setSuperServiceImplClass("org.pettyfox.base.web.dao.BaseService");
        strategy.setSuperEnumClass(BaseEnum.class.getName());
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(false);
        strategy.setTableFieldTypeConvert(convert);
        // 公共父类
//        strategy.setSuperControllerClass("org.pettyfox.base.web.BaseController");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id", "create_time", "update_time", "remark");
        strategy.setInclude(tables);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    private void buildTree(String modulesName, String dbName, String packagePath,
                           TableFieldTypeConvert convert,
                           String... tables) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(rootPath + "/src/main/java");
        gc.setAuthor("Petty Fox");
        gc.setOpen(false);
        gc.setSwagger2(false); //实体属性 Swagger2 注解
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(String.format(MYSQL_URL, dbName));
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(MYSQL_USER);
        dsc.setPassword(MYSQL_PWD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(modulesName);
        pc.setParent(packagePath);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("apiPrefix", "api");
                this.setMap(map);
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String filepath = rootPath + "/src/main/resources/repository/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                FileUtil.mkParentDirs(filepath);
                return filepath;
            }
        });
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                checkDir(filePath);
                if (!new File(filePath).exists()) {
                    return true;
                }
                if (FileType.ENTITY.equals(fileType)) {
                    // 允许生成模板文件
                    log.info("重新生成entity：{}", filePath);
                    return true;
                } else {
                    return false;
                }

            }
        });


        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
//        templateConfig.setController("/controller.java");

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix("t_ai");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(BaseTreeEntity.class.getName());
        strategy.setSuperServiceImplClass("org.pettyfox.base.web.dao.BaseService");
        strategy.setSuperEnumClass(BaseEnum.class.getName());
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(false);
        strategy.setTableFieldTypeConvert(convert);
        // 公共父类
//        strategy.setSuperControllerClass("org.pettyfox.base.web.BaseController");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id", "create_time", "update_time", "remark", "name", "parent_id", "parent_ids", "parent_names", "path_depth", "order_num");
        strategy.setInclude(tables);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
