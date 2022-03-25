package com.pettyfox.platform_example.account.interfaces.facade;

import com.pettyfox.platform_example.account.domain.biz.AccountBiz;
import com.pettyfox.platform_example.account.domain.biz.PermissionBiz;
import com.pettyfox.platform_example.account.interfaces.dto.data.PermissionTreeData;
import com.pettyfox.platform_example.account.interfaces.dto.dto.EditAccountDTO;
import com.pettyfox.platform_example.account.interfaces.dto.dto.ModifyPwdDTO;
import com.pettyfox.platform_example.account.interfaces.dto.params.AccountParam;
import com.pettyfox.platform_example.account.interfaces.dto.vo.AccountVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pettyfox.base.comm.log.ApiLog;
import org.pettyfox.base.comm.log.ApiLogType;
import org.pettyfox.base.comm.web.RestObjectResponse;
import org.pettyfox.base.web.context.UserContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@RestController
@Api(tags = "系统账户列表")
public class AccountController extends BaseController {

    @Resource
    private AccountBiz accountBiz;

    @Resource
    private PermissionBiz permissionBiz;

    @PostMapping("/account/list")
    @ApiOperation("账户列表")
    public RestObjectResponse<PageInfo<AccountVO>> list(@RequestBody AccountParam p) {
        return RestObjectResponse.ok(accountBiz.list(p));
    }

    @PostMapping("/account/getPermissionTree")
    @ApiOperation("账户权限")
    public RestObjectResponse<List<PermissionTreeData>> getTree() {
        accountBiz.updateActiveTime(UserContext.getUserId());
        return RestObjectResponse.ok(PermissionTreeData.buildByList(permissionBiz.listByRoleIds(Collections.singletonList(UserContext.getRoleId()))));
    }

    @PostMapping("/account/save")
    @ApiOperation("保存账户")
    @ApiLog(log = "保存账户", optionType = ApiLogType.OptionType.SAVE)
    public RestObjectResponse<String> save(@RequestBody EditAccountDTO d) {
        accountBiz.save(d);
        return RestObjectResponse.ok("");
    }

    @PostMapping("/account/restPassword")
    @ApiOperation("重置密码")
    @ApiLog(log = "重置密码", optionType = ApiLogType.OptionType.SAVE)
    public RestObjectResponse<String> restPassword(@RequestBody EditAccountDTO d) {
        d.validator();
        accountBiz.restPassword(d);
        return RestObjectResponse.ok("");
    }

    @PostMapping("/account/modifyPassword")
    @ApiOperation("修改密码")
    @ApiLog(log = "修改密码")
    public RestObjectResponse<String> modifyPassword(@RequestBody ModifyPwdDTO d) {
        d.validator();
        accountBiz.modifyPassword(d);
        return RestObjectResponse.ok("");
    }
}
