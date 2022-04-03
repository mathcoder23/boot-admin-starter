package com.pettyfox.platform_example.account.interfaces.facade;

import com.pettyfox.platform_example.account.domain.biz.SystemLogBiz;
import com.pettyfox.platform_example.account.domain.po.SystemLog;
import com.pettyfox.platform_example.account.interfaces.dto.params.SystemLogParams;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pettyfox.base.comm.web.RestObjectResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@Api(tags = "系统日志")
public class SystemLogRest extends BaseController {

    @Resource
    private SystemLogBiz systemLogBiz;

    @PostMapping(value = "/systemLog/list")
    @ResponseBody
    @ApiOperation("日志列表")
    public RestObjectResponse<PageInfo<SystemLog>> list(@RequestBody SystemLogParams p) throws IOException {
        PageInfo<SystemLog> page = systemLogBiz.list(p);

        return RestObjectResponse.ok(page);
    }
}
