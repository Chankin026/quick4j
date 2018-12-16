package com.chankin.ssms.core.feature.orm.dialect;
/*
 *  数据库方言工厂，产生方言对象
 * */


import org.apache.ibatis.session.Configuration;

public class DialectFactory {
    public static String dialectClass = null;

    public static Dialect buildDialect(Configuration configuration) {
        if (dialectClass == null) {
            synchronized (DialectFactory.class) {
                if (dialectClass == null) {
                    dialectClass = configuration.getVariables().getProperty("dilacetClass");
                }
            }
        }
        Dialect dialect = null;
        try {
            dialect = (Dialect) Class.forName(dialectClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("请检查mybatis-config.xml 中 dialectClass是否配置正确？");
        }
        return dialect;
    }
}
