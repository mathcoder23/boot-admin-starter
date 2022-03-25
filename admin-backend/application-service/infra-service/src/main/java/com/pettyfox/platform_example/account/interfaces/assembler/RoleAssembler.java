package com.pettyfox.platform_example.account.interfaces.assembler;

import com.pettyfox.platform_example.account.domain.po.Role;
import com.pettyfox.platform_example.account.interfaces.dto.vo.RoleVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RoleAssembler {
    public static RoleVO convert(Role account) {
        RoleVO vo = new RoleVO();
        BeanUtils.copyProperties(account, vo);
        return vo;
    }

    public static List<RoleVO> convert(List<Role> account) {
        return account.stream().map(RoleAssembler::convert).collect(Collectors.toList());
    }
}
