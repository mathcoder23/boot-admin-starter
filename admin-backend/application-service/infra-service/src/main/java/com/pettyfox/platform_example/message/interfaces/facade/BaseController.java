package com.pettyfox.platform_example.message.interfaces.facade;

import com.pettyfox.platform_example.message.config.MessageAggregateConfig;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(MessageAggregateConfig.API_PREFIX)
public abstract class BaseController {

}
