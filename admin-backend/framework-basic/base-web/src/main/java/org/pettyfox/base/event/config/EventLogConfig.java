package org.pettyfox.base.event.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Petty Fox
 * @version 1.0
 * @date 2021/8/6
 */
public class EventLogConfig {
    /**
     * 事件实体
     */
    private static Map<Object, Boolean> eventLogConfigMap = new HashMap<>();

    static {
//        eventLogConfigMap.put()
    }

    public static boolean hasEnableLog(Object obj) {
        return eventLogConfigMap.getOrDefault(obj, true);
    }
}
