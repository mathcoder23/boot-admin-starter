package com.pettyfox.platform_example.account.domain.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pettyfox.platform_example.account.domain.po.Role;
import com.pettyfox.platform_example.account.interfaces.dto.params.RoleParam;
import com.pettyfox.platform_example.account.interfaces.dto.vo.RoleVO;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Petty Fox
 * @since 2021-04-14
 */
public interface RoleBiz extends IService<Role> {

    PageInfo<RoleVO> list(RoleParam p);
}
