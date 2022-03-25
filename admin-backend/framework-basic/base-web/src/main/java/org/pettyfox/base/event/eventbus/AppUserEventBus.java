package org.pettyfox.base.event.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 识别记录事件总线
 *
 * @author eface
 * @version 1.0
 * @date 2020/9/25 10:57
 */
@Component
@Slf4j
public class AppUserEventBus extends AbstractSpringEventBus implements SubscriberExceptionHandler {
    private final EventBus eventBus;

    public AppUserEventBus() {
        eventBus = new AsyncEventBus(new ThreadPoolExecutor(1, 10,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>()), this);
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
        log.error("app user event handler exception", exception);
    }
}
