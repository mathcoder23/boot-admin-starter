package com.pettyfox.platform_example.message.domain.service;

import com.pettyfox.platform_example.message.interfaces.dto.SubscribeParamDTO;

import java.util.Map;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/9/23</p>
 * <p></p>
 *
 * @author Petty Fox
 */
public interface MessageSubscribeService {

    void subscribeMessage(SubscribeParamDTO dto);

    void unsubscribeMessage(SubscribeParamDTO dto);

    Map<String, SubscribeParamDTO> get(String channelId, String channelValue);
}
