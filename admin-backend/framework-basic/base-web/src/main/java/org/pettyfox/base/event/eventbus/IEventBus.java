package org.pettyfox.base.event.eventbus;

/**
 * @author eface
 * @version 1.0
 * @date 2020/9/25 10:57
 */
public interface IEventBus {
    /**
     * 发布事件
     *
     * @param event 事件实体
     */
    void post(Object event);

    /**
     * 添加消费者
     *
     * @param obj 消费者对象，默认以class为key
     */
    void addConsumer(Object obj);

    /**
     * 移除消费者
     *
     * @param obj 消费者对象，默认以class为key
     */
    void removeConsumer(Object obj);
}
