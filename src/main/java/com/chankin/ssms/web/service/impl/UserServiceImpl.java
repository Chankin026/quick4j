package com.chankin.ssms.web.service.impl;

import com.chankin.ssms.core.genericService.GenericDao;
import com.chankin.ssms.core.genericService.GenericServiceImpl;
import com.chankin.ssms.web.dao.UserMapper;
import com.chankin.ssms.web.model.User;
import com.chankin.ssms.web.model.UserExample;
import com.chankin.ssms.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public GenericDao<User, Long> getDao() {
        return userMapper;
    }

    @Override
    public int insert(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    //查找用户
    @Override
    public User selectByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        final List<User> list = userMapper.selectByExample(example);
        return list.get(0);
    }

    //用户登录验证查询
    @Override
    public User authentication(User user) {
        return userMapper.authentication(user);
    }

}
