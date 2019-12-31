package com.examplecn.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examplecn.demo.entity.User;
import com.examplecn.demo.model.ResponseModel;
import com.examplecn.demo.model.UserModel;

public interface UserService extends IService<User> {

    public ResponseModel create(UserModel userModel) throws Exception;
}
