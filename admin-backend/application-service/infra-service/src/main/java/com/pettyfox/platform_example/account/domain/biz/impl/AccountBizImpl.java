package com.pettyfox.platform_example.account.domain.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pettyfox.platform_example.account.domain.biz.AccountBiz;
import com.pettyfox.platform_example.account.domain.po.Account;
import com.pettyfox.platform_example.account.domain.repository.AccountMapper;
import com.pettyfox.platform_example.account.infrastructure.util.PasswordEncoderUtils;
import com.pettyfox.platform_example.account.interfaces.assembler.AccountAssembler;
import com.pettyfox.platform_example.account.interfaces.dto.dto.EditAccountDTO;
import com.pettyfox.platform_example.account.interfaces.dto.dto.ModifyPwdDTO;
import com.pettyfox.platform_example.account.interfaces.dto.params.AccountParam;
import com.pettyfox.platform_example.account.interfaces.dto.vo.AccountVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.pettyfox.base.comm.exception.DirtyException;
import org.pettyfox.base.utils.CommAssembler;
import org.pettyfox.base.web.context.UserContext;
import org.pettyfox.base.web.dao.BaseService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Petty Fox.m
 */
@Service
public class AccountBizImpl extends BaseService<AccountMapper, Account> implements AccountBiz {

    @Override
    public Account getByUsername(String s) {
        LambdaQueryWrapper<Account> queryChainWrapper = new LambdaQueryWrapper<>();
        queryChainWrapper.eq(Account::getUsername, s);
        return getOne(queryChainWrapper);
    }

    @Override
    public PageInfo<AccountVO> list(AccountParam p) {

        PageHelper.startPage(p.getPageNo(), p.getPageSize());
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(null != p.getType(), Account::getType, p.getType());
        if (StringUtils.isNotBlank(p.getAnyText())) {
            queryWrapper.and(q -> {
                q.or().like(Account::getNick, p.getAnyText())
                        .or().like(Account::getUsername, p.getAnyText());
            });
        }
        return new PageInfo<>(AccountAssembler.convert(this.list(queryWrapper)));
    }

    @Override
    public void updateActiveTime(Long id) {
        Account account = new Account();
        account.setId(id);
        account.setLastActiveTime(new Date());
        this.updateById(account);
    }

    @Override
    public void save(EditAccountDTO d) {
        d.validator();
        Account account = CommAssembler.convert(d, Account.class);
        account.setPassword(PasswordEncoderUtils.password(account.getUsername(), account.getPassword()));
        if (null == d.getId()) {
            if (null != getByUsername(d.getUsername())) {
                throw new DirtyException("账户名已存在");
            }
        }
        this.saveOrUpdate(account);
    }

    @Override
    public void restPassword(EditAccountDTO d) {
        if (null != d.getId() && StringUtils.isNotBlank(d.getPassword())) {
            Account old = this.getById(d.getId());
            if (null == old) {
                throw new DirtyException("用户不存在");
            }
            Account account = new Account();
            account.setId(d.getId());
            account.setPassword(PasswordEncoderUtils.password(old.getUsername(), d.getPassword()));
            this.updateById(account);
        }
    }

    @Override
    public void modifyPassword(ModifyPwdDTO d) {
        Account currentAccount = getById(UserContext.getUserId());
        if (null == currentAccount) {
            throw new DirtyException("当前用户不存在");
        }

        //验证旧密码
        String oldPwd = PasswordEncoderUtils.password(currentAccount.getUsername(), d.getPwd());
        if (!currentAccount.getPassword().equals(oldPwd)) {
            throw new DirtyException("旧密码错误");
        }

        // 更新密码
        Account account = new Account();
        account.setId(currentAccount.getId());
        account.setPassword(PasswordEncoderUtils.password(currentAccount.getUsername(), d.getNewPwd()));
        this.updateById(account);
    }

    @Override
    public int countByType(Account.Type type) {
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getType, type);
        return (int) count(queryWrapper);
    }

    @Override
    public int countByType(Account.Type type, Long roleId) {
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getType, type);
        queryWrapper.eq(Account::getRoleId, roleId);
        return (int) count(queryWrapper);
    }

}
