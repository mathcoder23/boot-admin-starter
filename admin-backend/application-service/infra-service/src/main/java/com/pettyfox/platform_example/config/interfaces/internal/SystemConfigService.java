package com.pettyfox.platform_example.config.interfaces.internal;

import com.pettyfox.platform_example.config.domain.biz.ConfigSystemBiz;
import com.pettyfox.platform_example.config.domain.po.SystemConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SystemConfigService {

    @Resource
    private ConfigSystemBiz configSystemBiz;

    public String getStr(String key) {
        SystemConfig config = configSystemBiz.getByConfigKey(key);
        if (null == config) {
            return "";
        }
        return config.getValue();
    }
}
