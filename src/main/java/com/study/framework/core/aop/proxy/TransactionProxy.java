package com.study.framework.core.aop.proxy;

import com.study.framework.core.annotation.Transaction;
import com.study.framework.core.aop.ProxyChen;
import com.study.framework.core.ioc.helper.DatabaseHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;


/**
 * 事物控制
 * Created by jackeyChen on 2016/11/8.
 */
public class TransactionProxy implements Proxy {

    static Logger LOGGER = LogManager.getLogger(TransactionProxy.class.getName());

    /**
     * 保证同一线程中事物控制逻辑只会执行一次
     */
    private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    @Override
    public Object doProxy(ProxyChen proxyChen) throws Throwable {
        Object result;
        boolean flag = FLAG_HOLDER.get();
        Method method = proxyChen.getTargetMethod();
        if(!flag && method.isAnnotationPresent(Transaction.class)) {
            FLAG_HOLDER.set(true);
            try {
                DatabaseHelper.beginTranscation();
                result = proxyChen.doProxyChen();
                DatabaseHelper.closeConnection();
            } catch ( Exception e) {
               DatabaseHelper.rollbackTransaction();
               throw e;
            } finally {
                FLAG_HOLDER.remove();
            }
        } else {
            result = proxyChen.doProxyChen();
        }
        return result;
    }
}
