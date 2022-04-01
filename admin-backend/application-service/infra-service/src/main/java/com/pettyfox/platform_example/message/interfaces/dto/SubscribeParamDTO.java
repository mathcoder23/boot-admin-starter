package com.pettyfox.platform_example.message.interfaces.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/9/23</p>
 * <p></p>
 *
 * @author Petty Fox
 */
@Getter
@Setter
public class SubscribeParamDTO {

    private String token;

    private String channelId;

    private String channelValue;
}
