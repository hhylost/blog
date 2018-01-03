package com.hhy.springchore.aop.service.impl;

import com.hhy.springchore.aop.service.UserService;

/**
 * 用户服务实现类
 *
 * @author hehy
 * @create 2017-12-27
 **/
public class UserServiceImpl implements UserService{
    public String getUserName(Integer id) {
        System.out.println("何海洋");
        return "何海洋";
    }
}
