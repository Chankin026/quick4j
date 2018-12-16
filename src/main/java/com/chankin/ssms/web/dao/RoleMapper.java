package com.chankin.ssms.web.dao;

import com.chankin.ssms.core.genericService.GenericDao;
import com.chankin.ssms.web.model.Role;
import com.chankin.ssms.web.model.RoleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

public interface RoleMapper extends GenericDao<Role, Long> {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    @Override
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    @Override
    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    @Override
    Role selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    @Override
    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 通过用户id 查询用户 拥有的角色
     *
     * @param id
     * @return
     */
    List<Role> selectRolesByUserId(Long userId);
}