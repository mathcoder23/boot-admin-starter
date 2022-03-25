package org.pettyfox.base.event.eventbus;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author eface
 * @version 1.0
 * @date 2020/9/25 11:23
 */
public abstract class AbstractSpringEventBus implements IEventBus, ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        this.scanConsumer(null);
    }

    public void scanConsumer(String packageName) {
        context.getBeansOfType(IEventConsumer.class).forEach((k, v) -> {
            this.addConsumer(v);
        });
        context.getBeansWithAnnotation(EventBusSubscribe.class).forEach((k, v) -> {
            this.addConsumer(v);
        });
    }
}
