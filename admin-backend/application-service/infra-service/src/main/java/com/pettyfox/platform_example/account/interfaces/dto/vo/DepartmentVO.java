package com.pettyfox.platform_example.account.interfaces.dto.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.pettyfox.base.comm.utils.SecretTextUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/10/13</p>
 * <p></p>
 *
 * @author Petty Fox
 */
@Getter
@Setter
public class DepartmentVO implements Serializable {

    private Long id;

    private String name;

    private String adminName;

    @Getter(value = AccessLevel.NONE)
    private String adminPhone;

    private String address;

    private String remark;

    private Date updateTime;

    public String getAdminPhone() {
        return SecretTextUtil.phone(adminPhone);
    }
}
