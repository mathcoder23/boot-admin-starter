package org.pettyfox.base.event.eventbus;

/**
 * @author eface
 * @version 1.0
 * @date 2020/9/25 11:19
 */
public interface IEventConsumer<T> {
    /**
     * 消费者事件
     *
     * @param event 事件
     */
    void consumer(T event);
}
