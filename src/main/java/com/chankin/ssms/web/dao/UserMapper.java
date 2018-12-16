package com.chankin.ssms.web.dao;

import com.chankin.ssms.core.feature.orm.mybatis.Page;
import com.chankin.ssms.core.genericService.GenericDao;
import com.chankin.ssms.web.model.User;
import com.chankin.ssms.web.model.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper extends GenericDao<User, Long> {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 用户登录验证查询
     *
     * @param 直接绑定xml里的参数record xml中 #{record.id}就可以得到user的id
     * @return
     */
    User authentication(@Param("record") User record);

    /**
     * 分页条件查询
     *
     * @param page
     * @param example
     * @return
     */

    List<User> selectByExampleAndPage(Page<User> page, UserExample example);
}