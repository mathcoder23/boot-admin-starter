package com.pettyfox.platform_example.account.domain.biz;


import com.baomidou.mybatisplus.extension.service.IService;
import com.pettyfox.platform_example.account.domain.po.Permission;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Petty Fox
 * @since 2021-04-14
 */
public interface PermissionBiz extends IService<Permission> {
    List<Permission> listByRoleIds(List<Long> roleIds);
}
