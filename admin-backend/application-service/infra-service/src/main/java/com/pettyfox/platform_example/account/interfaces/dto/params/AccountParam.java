package com.pettyfox.platform_example.account.interfaces.dto.params;

import com.pettyfox.platform_example.account.domain.po.Account;
import lombok.Getter;
import lombok.Setter;
import org.pettyfox.base.web.dto.params.BasePageParam;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/10/13</p>
 * <p></p>
 *
 * @author Petty Fox
 */
@Getter
@Setter
public class AccountParam extends BasePageParam {
    private Account.Type type;
    private String anyText;
}
