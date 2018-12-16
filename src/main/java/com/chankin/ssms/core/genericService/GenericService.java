package com.chankin.ssms.core.genericService;


import java.util.List;

/*
 *  所有自定义Service的钉机接口，封装常用的增删改查操作
 *  Model：代理数据库中表 所映射的Java对象类型
 *  T：代表对象的主键类型
 * */
public interface GenericService<Model, T> {
    //插入model对象
    int insert(Model model);

    //更新model对象
    int update(Model model);

    //通过主键，删除对象
    int delete(T id);

    //通过主键查询对象
    Model selectById(T id);

    //查询单个对象
    Model selectOne();

    //查询多个对象
    List<Model> selectAllList();

}
