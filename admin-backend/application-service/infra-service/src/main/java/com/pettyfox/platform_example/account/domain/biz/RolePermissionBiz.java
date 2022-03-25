package com.pettyfox.platform_example.account.domain.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pettyfox.platform_example.account.domain.po.RolePermission;
import com.pettyfox.platform_example.account.interfaces.dto.params.RolePermissionEditParams;
import com.pettyfox.platform_example.account.interfaces.dto.params.RolePermissionQueryParams;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Petty Fox
 * @since 2021-04-14
 */
public interface RolePermissionBiz extends IService<RolePermission> {

    void savePermission(RolePermissionEditParams p);

    PageInfo<RolePermission> listPage2(RolePermissionQueryParams query);

    List<RolePermission> list(List<Long> roleIds);
}
