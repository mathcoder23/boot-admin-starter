package org.pettyfox.tool.swagger2jsapi.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Petty Fox
 * @version 1.0
 */
@Getter
@Setter
public class SwaggerInfo {
    private String description;
    private String version;
    private String title;
    private JSONObject license;
}
