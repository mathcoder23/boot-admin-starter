package com.pettyfox.platform_example.message.interfaces.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by eface .FW on 2021/9/10</p>
 * <p></p>
 *
 * @author eface .FW
 */
@Getter
@Setter
public class MessageDTO {

    private String channel;
    private String channelValue;
    private String data;
}
