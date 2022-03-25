package org.pettyfox.tool.swagger2jsapi.bean;

import cn.hutool.core.date.DateUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Petty Fox
 * @version 1.0
 */
@Getter
@Setter
public class GenRoot {
    public GenRoot(String genRootFilePath,String templateFilePath,String templateGenApiFilePath,String moduleName,String author){
        this.templateFilePath = templateFilePath;
        this.genRootFilePath = genRootFilePath;
        this.templateGenApiFilePath = templateGenApiFilePath;
        this.moduleName = moduleName;
        this.author = author;
        this.genDate = DateUtil.formatDateTime(new Date());
    }

    /**
     * 生成的根路径
     */
    private String genRootFilePath;
    /**
     * 模板文件路径包含名称
     */
    private String templateFilePath;
    /**
     * GenApi的模板文件
     */
    private String templateGenApiFilePath;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 生成日期，自动创建
     */
    private String genDate;
    /**
     * 作者名称
     */
    private String author;
    private List<GenApi> genApiList = new ArrayList<>();
    private GenApi cGenApi;
    private String remark;
}
