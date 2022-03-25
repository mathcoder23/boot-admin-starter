package org.pettyfox.tool.swagger2jsapi.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Petty Fox
 * @version 1.0
 */
@Setter
@Getter
public class SwaggerRoot {
    private String swagger;
    private String host;
    private String basePath;
    private SwaggerInfo info;
    private List<SwaggerTag> tags;
    private JSONObject paths;
    private JSONObject definitions;
}
