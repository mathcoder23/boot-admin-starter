package com.pettyfox.platform_example.account.interfaces.assembler;

import com.pettyfox.platform_example.account.domain.po.Account;
import com.pettyfox.platform_example.account.interfaces.dto.vo.AccountVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AccountAssembler {

    public static AccountVO convert(Account account) {
        AccountVO vo = new AccountVO();
        BeanUtils.copyProperties(account, vo);
        return vo;
    }

    public static List<AccountVO> convert(List<Account> account) {
        return account.stream().map(AccountAssembler::convert).collect(Collectors.toList());
    }
}
