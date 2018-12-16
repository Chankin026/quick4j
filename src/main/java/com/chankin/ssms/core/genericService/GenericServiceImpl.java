package com.chankin.ssms.core.genericService;


import java.util.List;

/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作,
 * 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * T :代表对象的主键类型
 */
public abstract class GenericServiceImpl<Model, T> implements GenericService<Model, T> {

    //定义抽象方法，由子类实现，完成dao的注入
    public abstract GenericDao<Model, T> getDao();

    //插入对象
    @Override
    public int insert(Model model) {
        return getDao().insertSelective(model);
    }

    //更新对象
    @Override
    public int update(Model model) {
        return getDao().updateByPrimaryKeySelective(model);
    }

    //通过主键, 删除对象
    @Override
    public int delete(T id) {
        return getDao().deleteByPrimaryKey(id);
    }

    // 通过主键, 查询对象
    @Override
    public Model selectById(T id) {
        return getDao().selectByPrimaryKey(id);
    }

    //
    @Override
    public Model selectOne() {
        return null;
    }

    @Override
    public List<Model> selectAllList() {
        return getDao().selectByExample();
    }
}
