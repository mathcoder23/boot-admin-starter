package com.pettyfox.platform_example.account.domain.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pettyfox.platform_example.account.domain.biz.RoleBiz;
import com.pettyfox.platform_example.account.domain.po.Role;
import com.pettyfox.platform_example.account.domain.repository.RoleMapper;
import com.pettyfox.platform_example.account.interfaces.dto.params.RoleParam;
import com.pettyfox.platform_example.account.interfaces.dto.vo.RoleVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.pettyfox.base.utils.CommAssembler;
import org.pettyfox.base.web.dao.BaseService;
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
public class RoleBizImpl extends BaseService<RoleMapper, Role> implements RoleBiz {

    @Override
    public PageInfo<RoleVO> list(RoleParam p) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        PageHelper.startPage(p.getPageNo(), p.getPageSize());
        PageInfo<Role> pageInfo = new PageInfo<>(this.list(queryWrapper));
        return CommAssembler.convert(pageInfo, RoleVO.class);
    }

}
