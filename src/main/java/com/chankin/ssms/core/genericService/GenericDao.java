package com.chankin.ssms.core.genericService;

import java.util.List;

public interface GenericDao<Model, T> {

    //插入对象
    int insertSelective(Model model);

    //更新对象
    int updateByPrimaryKeySelective(Model model);

    //通过主键，删除对象
    int deleteByPrimaryKey(T id);

    //通过主键查询对象
    Model selectByPrimaryKey(T id);

    //查询所有对象集合
    List<Model> selectByExample();

}
