package com.pettyfox.platform_example.config.interfaces.dto.vo;

import com.pettyfox.platform_example.config.domain.po.SystemConfig;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ApiModel("系统配置")
public class SystemConfigVO implements Serializable {

    private Long id;
    private String configKey;
    private String value;
    private String defaultValue;
    private String label;
    private SystemConfig.Type type;
    private Date createTime;
    private Date updateTime;
    private Long modifyBy;
    private String modifyNameBy;
    private Long systemConfigGroupId;
    private String remark;
}
