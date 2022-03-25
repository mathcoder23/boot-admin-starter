package org.pettyfox.tool.swagger2jsapi.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * js代码文件生成的最小单位
 * @author Petty Fox
 * @version 1.0
 */
@Getter
@Setter
public class GenApi {
    /**
     * 前端接口类名称
     */
    private String objName;
    private List<GenCmd> cmdList;
    private String filePath;
    /**
     * uri前缀，并非baseUrl
     */
    private String uriPrefix;
    /**
     * 核心接口工具导入路径
     */
    private String importCore;
}
