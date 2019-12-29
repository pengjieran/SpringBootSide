package com.examplecn.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examplecn.demo.entity.Account;
import com.examplecn.demo.mapper.AccountMapper;
import com.examplecn.demo.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
}
