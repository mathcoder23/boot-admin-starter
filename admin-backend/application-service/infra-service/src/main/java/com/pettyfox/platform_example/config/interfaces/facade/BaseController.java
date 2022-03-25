package com.pettyfox.platform_example.config.interfaces.facade;

import com.pettyfox.platform_example.config.infrastructure.config.ConfigAggregateConfig;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ConfigAggregateConfig.API_PREFIX)
public abstract class BaseController {

}
