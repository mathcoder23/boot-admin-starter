package com.pettyfox.platform_example.account.interfaces.dto.dto;

import com.pettyfox.platform_example.account.domain.po.Account;
import lombok.Getter;
import lombok.Setter;
import org.pettyfox.base.web.dto.params.BaseParams;

@Getter
@Setter
public class EditAccountDTO extends BaseParams {

    private Long id;
    private String username;
    private String nick;
    private String password;
    private Boolean enable;
    private Long roleId;
    private Account.Type type;
    private Long departmentId;
}
