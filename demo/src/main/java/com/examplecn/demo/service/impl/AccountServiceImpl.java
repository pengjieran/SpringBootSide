package com.examplecn.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examplecn.demo.entity.Account;
import com.examplecn.demo.mapper.AccountMapper;
import com.examplecn.demo.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public Account getByUsername(String username) {

        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Account.USERNAME, username);
        return getOne(queryWrapper);
    }
}
