package com.chankin.ssms.web.service;

import com.chankin.ssms.core.genericService.GenericService;
import com.chankin.ssms.web.model.User;

/*
 *  用户业务接口
 * */
public interface UserService extends GenericService<User, Long> {

    //用户验证
    User authentication(User user);

    //根据用户名查询用户
    User selectByUsername(String username);


}
