package com.pettyfox.platform_example.message.domain.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.pettyfox.platform_example.message.domain.service.MessageSubscribeService;
import com.pettyfox.platform_example.message.interfaces.dto.SubscribeParamDTO;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/9/23</p>
 * <p></p>
 *
 * @author Petty Fox
 */
@Component
public class MessageSubscribeServiceImpl implements MessageSubscribeService {

    private final ConcurrentHashMap<String, ConcurrentHashMap<String, SubscribeParamDTO>> MAP = new ConcurrentHashMap<>();

    @Override
    public synchronized void subscribeMessage(SubscribeParamDTO dto) {
        String key = dto.getChannelId() + ":" + dto.getChannelValue();
        ConcurrentHashMap<String, SubscribeParamDTO> temp = MAP.computeIfAbsent(key, k -> new ConcurrentHashMap<>());
        String tokenKey = SecureUtil.md5(dto.getToken());
        if (!temp.containsKey(tokenKey)) {
            temp.put(tokenKey, dto);
        }
    }

    @Override
    public synchronized void unsubscribeMessage(SubscribeParamDTO dto) {
        String key = dto.getChannelId() + ":" + dto.getChannelValue();
        String tokenKey = SecureUtil.md5(dto.getToken());
        ConcurrentHashMap<String, SubscribeParamDTO> temp = MAP.computeIfAbsent(key, k -> new ConcurrentHashMap<>());
        temp.remove(tokenKey);
    }

    @Override
    public Map<String, SubscribeParamDTO> get(String channelId, String channelValue) {
        String key = channelId + ":" + channelValue;
        return MAP.get(key);
    }
}
