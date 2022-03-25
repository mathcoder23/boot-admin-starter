package com.pettyfox.platform_example.account.domain.biz.impl;

import com.pettyfox.platform_example.account.domain.biz.DepartmentBiz;
import com.pettyfox.platform_example.account.domain.po.Department;
import com.pettyfox.platform_example.account.domain.repository.DepartmentMapper;
import com.pettyfox.platform_example.account.interfaces.dto.vo.DepartmentVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.pettyfox.base.utils.CommAssembler;
import org.pettyfox.base.web.dao.BaseService;
import org.pettyfox.base.web.dto.params.BasePageParam;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Petty Fox
 * @since 2021-04-14
 */
@Service
public class DepartmentBizImpl extends BaseService<DepartmentMapper, Department> implements DepartmentBiz {

    @Override
    public PageInfo<DepartmentVO> list(BasePageParam p) {
        PageHelper.startPage(p.getPageNo(), p.getPageSize());
        PageInfo<Department> pageInfo = new PageInfo<>(this.list());
        return CommAssembler.convert(pageInfo, DepartmentVO.class);
    }
}
