package com.pettyfox.platform_example.account.interfaces.facade;

import com.pettyfox.platform_example.account.infrastructure.config.AccountAggregateConfig;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(AccountAggregateConfig.API_PREFIX)
public abstract class BaseController {

}
