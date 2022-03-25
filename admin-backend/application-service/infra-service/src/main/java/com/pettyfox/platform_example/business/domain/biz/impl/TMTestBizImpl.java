package com.pettyfox.platform_example.business.domain.biz.impl;

import com.pettyfox.platform_example.business.domain.po.TMTest;
import com.pettyfox.platform_example.business.domain.repository.TMTestMapper;
import com.pettyfox.platform_example.business.domain.biz.TMTestBiz;
import org.pettyfox.base.web.dao.BaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Petty Fox
 * @since 2022-03-24
 */
@Service
public class TMTestBizImpl extends BaseService<TMTestMapper, TMTest> implements TMTestBiz {

}
