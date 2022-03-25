package com.pettyfox.platform_example.account.interfaces.facade;


import com.pettyfox.platform_example.account.domain.biz.RoleBiz;
import com.pettyfox.platform_example.account.domain.po.Role;
import com.pettyfox.platform_example.account.infrastructure.config.AccountAggregateConfig;
import com.pettyfox.platform_example.account.interfaces.dto.params.RoleParam;
import com.pettyfox.platform_example.account.interfaces.dto.vo.RoleVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pettyfox.base.comm.log.ApiLog;
import org.pettyfox.base.comm.log.ApiLogType;
import org.pettyfox.base.comm.web.RestObjectResponse;
import org.pettyfox.base.web.dto.params.BaseIdsParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Petty Fox
 * @since 2021-04-14
 */
@RestController
@Api(tags = "系统角色")
@RequestMapping(AccountAggregateConfig.API_PREFIX)
public class RoleController {

    @Resource
    private RoleBiz roleService;

    @PostMapping("/role/list")
    @ApiOperation("系统角色列表")
    public RestObjectResponse<PageInfo<RoleVO>> list(@RequestBody RoleParam p) {
        return RestObjectResponse.ok(roleService.list(p));
    }


    @PostMapping("/role/save")
    @ApiLog(log = "保存", optionType = ApiLogType.OptionType.SAVE)
    public RestObjectResponse<Role> save(@RequestBody Role entity) {
        boolean result = roleService.saveOrUpdate(entity);
        return RestObjectResponse.ok(null);
    }

    @ApiLog(log = "删除", optionType = ApiLogType.OptionType.DELETE_BATCH)
    @PostMapping("/role/delete")
    public RestObjectResponse<String> delete(@RequestBody BaseIdsParams p) {
        roleService.removeByIds(p.getIds());
        return RestObjectResponse.ok("删除成功");
    }

}
