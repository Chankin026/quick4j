package com.chankin.ssms.web.service;


import com.chankin.ssms.core.genericService.GenericService;
import com.chankin.ssms.web.model.Role;

import java.util.List;

/*
 *  角色业务接口
 * */
public interface RoleService extends GenericService<Role, Long> {

    //通过角色id 查询用户所拥有的角色
    List<Role> selectRolesByUserId(Long roleId);
}
