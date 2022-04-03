package com.pettyfox.platform_example.business.domain.biz.impl;

import com.pettyfox.platform_example.business.domain.po.Test;
import com.pettyfox.platform_example.business.domain.repository.TestMapper;
import com.pettyfox.platform_example.business.domain.biz.TestBiz;
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
public class TestBizImpl extends BaseService<TestMapper, Test> implements TestBiz {

}
