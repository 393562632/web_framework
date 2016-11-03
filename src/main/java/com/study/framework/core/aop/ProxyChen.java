package com.study.framework.core.aop;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackeyChen on 2016/11/1.
 */
public class ProxyChen {
    //目标类
    private final Class<?> targetClass;
    //目标对象
    private final Object targetObject;
    //目标方法
    private final Method targetMethod;
    //方法代理
    private final MethodProxy methodProxy;
    //方法参数
    private final Object[] methodParam;
    //代理列表
    private List<Proxy> proxyList = new ArrayList<>();
    //代理索引
    private int proxyIndex = 0;

    public ProxyChen(Class<?> targetClass,
                     Object targetObject,
                     Method targetMethod,
                     MethodProxy methodProxy,
                     Object[] methodParam,
                     List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.methodParam = methodParam;
        this.proxyList = proxyList;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object[] getMethodParam() {
        return methodParam;
    }

    public Object doProxyChen() throws Throwable {
        Object methodResult;
        if (proxyIndex < proxyList.size()) {
            methodResult = proxyList.get(proxyIndex++).doProxy(this);
        } else {
            methodResult = methodProxy.invokeSuper(targetObject, methodParam);
        }
        return methodResult;
    }
}
