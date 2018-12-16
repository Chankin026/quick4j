package com.chankin.ssms.core.feature.orm.dialect;

/*
 * 数据库方言抽象类
 **/
public abstract class Dialect {
    //得到分页sql
    public abstract String getLimitString(String sql, int offset, int limit);

    //得到总数量sql
    public abstract String getCountString(String sql);
}
