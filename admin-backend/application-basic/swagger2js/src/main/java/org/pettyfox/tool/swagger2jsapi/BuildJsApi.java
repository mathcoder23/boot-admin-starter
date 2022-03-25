package org.pettyfox.tool.swagger2jsapi;

import org.pettyfox.tool.swagger2jsapi.bean.GenRoot;

/**
 * 生成jsApi的接口类
 * @author Petty Fox
 * @version 1.0
 */
public interface BuildJsApi {
    /**
     * 根据GenRoot参数生成apiUrl中的json配置
     * @param apiUrl 接口地址
     * @param pathFilter 路径过滤正则
     * @param genRoot 生成配置
     */
    void startGen(String apiUrl, String pathFilter, GenRoot genRoot);
}

