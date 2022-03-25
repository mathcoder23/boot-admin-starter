package org.pettyfox.base.event.aop;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"org.pettyfox.base.event"})
public @interface EnableEventBus {
}
