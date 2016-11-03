package com.study.framework.core.aop;

/**
 * Created by jackeyChen on 2016/11/1.
 */
public interface Proxy {
    /**
     * 执行链式处理
     */
    Object doProxy(ProxyChen proxyChen) throws Throwable;
}
