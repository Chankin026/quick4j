package com.chankin.ssms.web.interceptors;

import com.chankin.ssms.core.feature.orm.dataSources.DataSourceTypeManager;
import com.chankin.ssms.core.feature.orm.dataSources.DataSources;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect    // for aop
@Component // for auto scan
@Order(0)  // execute before @Transactional
public class DataSourceInterceptor {
    @Pointcut("execution(* com.chankin.ssms.web.service..*(..))")
    public void dataSourceSlave() {
    }

    ;

    @Before("dataSourceSlave()")
    public void before(JoinPoint jp) {
        DataSourceTypeManager.set(DataSources.MYSQL);
    }
    // ... ...

}
