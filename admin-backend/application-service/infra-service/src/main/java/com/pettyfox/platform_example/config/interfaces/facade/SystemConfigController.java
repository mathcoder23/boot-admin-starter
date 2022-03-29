package com.pettyfox.platform_example.config.interfaces.facade;

import com.pettyfox.platform_example.config.domain.biz.ConfigSystemBiz;
import com.pettyfox.platform_example.config.domain.biz.ConfigSystemGroupBiz;
import com.pettyfox.platform_example.config.domain.po.SystemConfig;
import com.pettyfox.platform_example.config.interfaces.dto.data.SystemConfigModifyData;
import com.pettyfox.platform_example.config.interfaces.dto.vo.SystemConfigGroupVO;
import com.pettyfox.platform_example.config.interfaces.facade.dto.ConfigEdit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pettyfox.base.comm.log.ApiLog;
import org.pettyfox.base.comm.log.ApiLogType;
import org.pettyfox.base.comm.web.RestObjectResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "系统配置管理")
public class SystemConfigController extends BaseController {

    @Resource
    private ConfigSystemGroupBiz configSystemGroupBiz;
    @Resource
    private ConfigSystemBiz configSystemBiz;

    @ApiOperation("获取所有系统配置")
    @GetMapping("/systemConfig/getAllConfig")
    public RestObjectResponse<List<SystemConfigGroupVO>> getAllConfig() {
        return RestObjectResponse.ok(configSystemGroupBiz.getAllConfig());
    }

    @ApiOperation("获取配置")
    @GetMapping("/systemConfig/getConfigByKey")
    public RestObjectResponse<SystemConfig> getConfigByKey(@RequestParam String key) {
        return RestObjectResponse.ok(configSystemBiz.getByConfigKey(key));
    }

    @ApiOperation("保存配置")
    @PostMapping("/systemConfig/saveConfigByKey")
    public RestObjectResponse<String> saveConfigByKey(@RequestBody ConfigEdit configEdit) {
        configSystemBiz.saveByConfigKey(configEdit);
        return RestObjectResponse.ok(null);
    }

    @ApiOperation("批量保存配置")
    @PostMapping("/systemConfig/simpleBatchModify")
    @ApiLog(log = "修改系统参数配置", optionType = ApiLogType.OptionType.SAVE)
    public RestObjectResponse<String> simpleBatchModify(@RequestBody List<SystemConfigModifyData> list) {
        configSystemBiz.simpleBatchModify(list);
        return RestObjectResponse.ok("");
    }
}
