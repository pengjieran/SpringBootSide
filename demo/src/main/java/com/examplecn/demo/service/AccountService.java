package com.examplecn.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examplecn.demo.entity.Account;

public interface AccountService extends IService<Account> {

    Account getByUsername(String username);
}
