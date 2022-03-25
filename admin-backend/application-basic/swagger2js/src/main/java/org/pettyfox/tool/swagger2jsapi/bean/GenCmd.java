package org.pettyfox.tool.swagger2jsapi.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Petty Fox
 * @version 1.0
 */
@Getter
@Setter
public class GenCmd {
    /**
     * 指令名称
     */
    private String cmdName;
    private String uri;
    private String params;
    private String body;
    private String response;
    /**
     * 响应类型，json、blob。针对下载
     */
    private String responseType;
    /**
     * 接口方法，post、get、put等
     */
    private String apiMethod;
    private String remark;
}
