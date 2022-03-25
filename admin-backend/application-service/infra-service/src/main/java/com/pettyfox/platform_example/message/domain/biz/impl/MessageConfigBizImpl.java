package com.pettyfox.platform_example.message.domain.biz.impl;

import com.pettyfox.platform_example.config.interfaces.internal.SystemConfigService;
import com.pettyfox.platform_example.message.domain.biz.MessageConfigBiz;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MessageConfigBizImpl implements MessageConfigBiz {

    @Resource
    private SystemConfigService systemConfigService;

    @Override
    public String getWebsocketIp() {
        return systemConfigService.getStr("MESSAGE_WS_IP");
    }

    @Override
    public String getWebsocketPort() {
        return systemConfigService.getStr("MESSAGE_WS_PORT");
    }

    @Override
    public String getWebsocketProto() {
        return systemConfigService.getStr("MESSAGE_WS_PROTO");
    }
}
