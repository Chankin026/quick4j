package com.chankin.ssms.web.service.impl;

import com.chankin.ssms.core.genericService.GenericDao;
import com.chankin.ssms.core.genericService.GenericServiceImpl;
import com.chankin.ssms.web.dao.RoleMapper;
import com.chankin.ssms.web.model.Role;
import com.chankin.ssms.web.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 *  角色Service实现类
 *
 * */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public GenericDao<Role, Long> getDao() {
        return roleMapper;
    }


    @Override
    public List<Role> selectRolesByUserId(Long userId) {
        return roleMapper.selectRolesByUserId(userId);
    }


}
