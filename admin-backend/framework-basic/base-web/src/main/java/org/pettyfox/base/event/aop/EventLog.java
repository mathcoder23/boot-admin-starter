package org.pettyfox.base.event.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author eface
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventLog {
    /**
     * 日志打印策略
     * @return 策略
     */
    EventLogStrategy strategy() default EventLogStrategy.CONFIG;
}