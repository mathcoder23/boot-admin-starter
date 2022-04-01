package com.pettyfox.platform_example.account.interfaces.dto.data;

import lombok.Getter;
import lombok.Setter;
import org.pettyfox.base.web.dto.params.BaseValidator;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/10/13</p>
 * <p></p>
 *
 * @author Petty Fox
 */
@Getter
@Setter
public class DepartmentEdit implements BaseValidator {

    private Long id;

    private String name;

    private String adminName;

    private String adminPhone;

    private String address;
}
