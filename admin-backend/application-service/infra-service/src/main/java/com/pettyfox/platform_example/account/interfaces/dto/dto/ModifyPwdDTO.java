package com.pettyfox.platform_example.account.interfaces.dto.dto;

import lombok.Getter;
import lombok.Setter;
import org.pettyfox.base.web.dto.params.BaseValidator;


/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by eface .FW on 2021/11/22</p>
 * <p></p>
 *
 * @author eface .FW
 */
@Getter
@Setter
public class ModifyPwdDTO implements BaseValidator {
    private String pwd;
    private String newPwd;
}
