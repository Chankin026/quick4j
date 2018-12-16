package com.chankin.ssms.web.service.impl;

import com.chankin.ssms.core.genericService.GenericDao;
import com.chankin.ssms.core.genericService.GenericServiceImpl;
import com.chankin.ssms.web.dao.PermissionMapper;
import com.chankin.ssms.web.model.Permission;
import com.chankin.ssms.web.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 *   权限Service实验类
 *
 * */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Long> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public GenericDao<Permission, Long> getDao() {
        return permissionMapper;
    }

    //根据用户id查询权限
    @Override
    public List<Permission> selectPermissionsByRoleId(Long roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }
}
