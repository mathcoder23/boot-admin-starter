package com.pettyfox.platform_example.account.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.pettyfox.base.web.dao.BaseEntitySnowId;

/**
 * <p>
 *
 * </p>
 *
 * @author Petty Fox
 * @since 2021-04-15
 */
@Getter
@Setter
@TableName("t_department")
@ApiModel(value = "", description = "")
public class Department extends BaseEntitySnowId {

    private static final long serialVersionUID = 1L;

    private String name;

    private String adminName;

    private String adminPhone;

    private String address;

}
