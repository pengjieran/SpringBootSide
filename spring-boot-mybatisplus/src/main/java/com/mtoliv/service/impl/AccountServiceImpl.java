package com.mtoliv.service.impl;

import com.mtoliv.entity.Account;
import com.mtoliv.mapper.dao.AccountMapper;
import com.mtoliv.service.AccountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2018-06-12
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
