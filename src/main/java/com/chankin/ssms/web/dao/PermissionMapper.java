package com.chankin.ssms.web.dao;

import com.chankin.ssms.core.genericService.GenericDao;
import com.chankin.ssms.web.model.Permission;
import com.chankin.ssms.web.model.PermissionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PermissionMapper extends GenericDao<Permission, Long> {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    @Override
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    @Override
    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    @Override
    Permission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    @Override
    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 通过角色id 查询角色 拥有的权限
     *
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(Long roleId);
}