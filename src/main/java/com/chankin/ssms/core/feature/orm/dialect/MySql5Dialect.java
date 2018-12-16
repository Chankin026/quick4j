package com.chankin.ssms.core.feature.orm.dialect;

import java.net.SocketImplFactory;
import java.util.List;

public class MySql5Dialect extends Dialect {
    protected static final String SQL_END_DELIMITER = ";";

    @Override
    public String getLimitString(String sql, int offset, int limit) {

        return MySql5Pagehepler.getLimitString(sql, offset, limit);

    }

    @Override
    public String getCountString(String sql) {
        return MySql5Pagehepler.getCountString(sql);
    }
}
