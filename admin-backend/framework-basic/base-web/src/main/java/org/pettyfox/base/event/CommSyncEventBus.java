package org.pettyfox.base.event;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.pettyfox.base.event.eventbus.AbstractSpringEventBus;
import org.springframework.stereotype.Component;

/**
 * 通用同步事件总线
 *
 * @author eface
 * @version 1.0
 * @date 2020/9/25 10:57
 */
@Component
@Slf4j
public class CommSyncEventBus extends AbstractSpringEventBus implements SubscriberExceptionHandler {
    private final EventBus eventBus;

    public CommSyncEventBus() {
        eventBus = new EventBus(this);
    }


    @Override
    public void post(Object event) {
        eventBus.post(event);
    }

    @Override
    public void addConsumer(Object obj) {
        eventBus.register(obj);
    }

    @Override
    public void removeConsumer(Object obj) {
        eventBus.unregister(obj);
    }

    @Override
    public void handleException(Throwable exception, SubscriberExceptionContext context) {
        log.error("CommSyncEventBus event handler exception", exception);
    }
}
