package com.chankin.ssms.core.feature.orm.dataSources;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceTypeManager extends AbstractRoutingDataSource {
    private static final ThreadLocal<DataSources> dataSourceTypes = new ThreadLocal<DataSources>() {
        @Override
        protected DataSources initialValue() {
            return DataSources.MYSQL;
        }
    };

    public static DataSources get() {
        return dataSourceTypes.get();
    }

    public static void set(DataSources dataSourceType) {
        dataSourceTypes.set(dataSourceType);
    }

    public static void reset() {
        dataSourceTypes.set(DataSources.MYSQL);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceTypeManager.get();
    }
}
