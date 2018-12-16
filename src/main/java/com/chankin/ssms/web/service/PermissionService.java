package com.chankin.ssms.web.service;


import com.chankin.ssms.core.genericService.GenericService;
import com.chankin.ssms.web.model.Permission;

import java.util.List;

/*
 *  权限业务接口
 * */
public interface PermissionService extends GenericService<Permission, Long> {

    //通过角色id 查询角色拥有的权限
    List<Permission> selectPermissionsByRoleId(Long roleId);
}
