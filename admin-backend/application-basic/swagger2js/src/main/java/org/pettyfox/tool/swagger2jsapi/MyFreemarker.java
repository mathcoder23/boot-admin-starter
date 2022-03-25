package org.pettyfox.tool.swagger2jsapi;

import com.alibaba.fastjson.JSONObject;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 核心的基于Freemarker模板引擎处理
 */
@Slf4j
public class MyFreemarker {

    public static void generate(JSONObject root, File outFile, File templateFile) throws IOException, TemplateException {
        log.info("generating {} form {}",outFile,templateFile);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(templateFile.getParentFile());
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
        Template temp = cfg.getTemplate(templateFile.getName());
        if(!outFile.getParentFile().exists()){
            outFile.getParentFile().mkdirs();
        }
        FileWriter fw = new FileWriter(outFile);
        BufferedWriter bw = new BufferedWriter(fw);
        temp.process(root, bw);
        bw.flush();
        fw.close();
    }
}