package com.pettyfox.platform_example.message.interfaces.dto;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/9/10</p>
 * <p>二进制消息 协议包装</p>
 *
 * @author Petty Fox
 */
public class MessageBinaryWrapper {

    /**
     * 协议说明 head(12字节)部分：short(channel长度) short(channel value 长度) int(数据长度) int(保留)
     * 整型按照大端序写入
     * 数据区
     *
     * @param channel
     * @param channelValue
     * @param data
     * @return
     */
    public static byte[] wrapper(String channel, String channelValue, byte[] data) {
        int allLen = 12 + channel.length() + channelValue.length() + data.length;
        ByteBuf buf = Unpooled.buffer(allLen);
        //写入头部
        buf
                .writeShort(channel.length())
                .writeShort(channelValue.length())
                .writeInt(data.length)
                .writeInt(0)
                .writeBytes(channel.getBytes())
                .writeBytes(channelValue.getBytes())
                .writeBytes(data);
        return buf.array();
    }
}
