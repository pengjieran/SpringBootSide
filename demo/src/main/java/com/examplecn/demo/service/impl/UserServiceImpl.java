package com.examplecn.demo.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examplecn.demo.entity.Account;
import com.examplecn.demo.entity.User;
import com.examplecn.demo.mapper.AccountMapper;
import com.examplecn.demo.mapper.UserMapper;
import com.examplecn.demo.model.ResponseModel;
import com.examplecn.demo.model.UserModel;
import com.examplecn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private AccountMapper accountMapper;

    @Transactional
    @Override
    public ResponseModel create(UserModel userModel) {

        QueryChainWrapper<Account> accountQueryChainWrapper = new QueryChainWrapper<>(accountMapper);
        Account account = accountQueryChainWrapper.eq(Account.USERNAME, userModel.getUsername()).one();
        if (null != account) return new ResponseModel("5000", "账号已存在！");
        account = new Account();
        account.setUsername(userModel.getUsername());
        account.setPassword(SecureUtil.sha256(userModel.getPassword()));
        User user = new User();
        user.setNickName(userModel.getNickName());
        save(user);
        account.setUserId(user.getId());
        accountMapper.insert(account);
        return ResponseModel.success(account);
    }
}
