package com.pettyfox.platform_example.account.domain.biz;

import com.pettyfox.platform_example.account.domain.po.Account;
import com.pettyfox.platform_example.account.interfaces.dto.dto.EditAccountDTO;
import com.pettyfox.platform_example.account.interfaces.dto.dto.ModifyPwdDTO;
import com.pettyfox.platform_example.account.interfaces.dto.params.AccountParam;
import com.pettyfox.platform_example.account.interfaces.dto.vo.AccountVO;
import com.github.pagehelper.PageInfo;

public interface AccountBiz {

    Account getByUsername(String s);

    PageInfo<AccountVO> list(AccountParam p);

    void updateActiveTime(Long id);

    void save(EditAccountDTO d);

    void restPassword(EditAccountDTO d);

    int countByType(Account.Type type);

    int countByType(Account.Type type, Long roleId);

    void modifyPassword(ModifyPwdDTO d);
}
