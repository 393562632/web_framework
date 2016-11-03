package com.study.framework.core.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by jackeyChen on 2016/11/1.
 */
public abstract class AspectProxy implements Proxy {

    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChen proxyChen) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChen.getTargetClass();
        Method method = proxyChen.getTargetMethod();
        Object[] params = proxyChen.getMethodParam();
        begin();

        try {
            if(intercept(cls, method, params)) {
                before(cls, method, params);
                result = proxyChen.doProxyChen();
                after(cls, method, params, result);
            } else {
                result = proxyChen.doProxyChen();
            }
        } catch (Exception e) {
            logger.error("proxy failure", e);
            error(cls, method, params, e);
        } finally {
            end();
        }
        return result;
    }

    public void begin() {

    }

    public boolean intercept(Class<?> cls, Method method, Object[] param) throws Throwable {
        return true;
    }

    public void before(Class<?> cls, Method method, Object[] params) throws Throwable{

    }

    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable{

    }

    public void error(Class<?> cls, Method method, Object[] params, Throwable e) throws Throwable{

    }

    public void end() {

    }
}
