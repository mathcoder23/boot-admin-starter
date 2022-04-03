package com.pettyfox.platform_example.account.interfaces.facade;


import com.pettyfox.platform_example.account.domain.biz.DepartmentBiz;
import com.pettyfox.platform_example.account.domain.po.Department;
import com.pettyfox.platform_example.account.infrastructure.config.AccountAggregateConfig;
import com.pettyfox.platform_example.account.interfaces.dto.data.DepartmentEdit;
import com.pettyfox.platform_example.account.interfaces.dto.vo.DepartmentVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pettyfox.base.comm.log.ApiLog;
import org.pettyfox.base.comm.log.ApiLogType;
import org.pettyfox.base.comm.web.RestObjectResponse;
import org.pettyfox.base.utils.CommAssembler;
import org.pettyfox.base.web.dto.params.BaseIdsParams;
import org.pettyfox.base.web.dto.params.BasePageParam;
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
@Api(tags = "系统部门")
@RequestMapping(AccountAggregateConfig.API_PREFIX + "/department")

public class DepartmentController {

    @Resource
    private DepartmentBiz departmentBiz;

    @PostMapping("/list")
    @ApiOperation("系统部门列表")
    public RestObjectResponse<PageInfo<DepartmentVO>> list(@RequestBody BasePageParam p) {
        return RestObjectResponse.ok(departmentBiz.list(p));
    }

    @PostMapping("/save")
    @ApiLog(log = "保存", optionType = ApiLogType.OptionType.SAVE)
    public RestObjectResponse<String> save(@RequestBody DepartmentEdit entity) {
        entity.validator();
        if (null != entity.getAdminPhone() && entity.getAdminPhone().contains("*")) {
            entity.setAdminPhone(null);
        }
        boolean result = departmentBiz.saveOrUpdate(CommAssembler.convert(entity, Department.class));
        return RestObjectResponse.ok(null);
    }

    @ApiLog(log = "删除", optionType = ApiLogType.OptionType.DELETE_BATCH)
    @PostMapping("/delete")
    public RestObjectResponse<String> delete(@RequestBody BaseIdsParams p) {
        departmentBiz.removeByIds(p.getIds());
        return RestObjectResponse.ok("删除成功");
    }

}
