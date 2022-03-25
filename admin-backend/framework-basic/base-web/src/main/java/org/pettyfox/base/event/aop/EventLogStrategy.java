package org.pettyfox.base.event.aop;

/**
 * @author eface .FW
 * @version 1.0
 * @date 2021/8/6 17:13
 */
public enum EventLogStrategy {
    /**
     * 根据配置来决定是否打印
     */
    CONFIG,
    /**
     * 开启日志
     */
    ENABLE,
    /**
     * 禁用日志
     */
    DISABLE
}
