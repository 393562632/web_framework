package com.study.framework.core.ioc.helper;

import com.study.framework.core.annotation.Aspect;
import com.study.framework.core.aop.AspectProxy;
import com.study.framework.core.aop.Proxy;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created by jackeyChen on 2016/11/2.
 */
public final class AopHelper {

    /**
     * 获取被 @Aspect 注解标注的所有类，并且不包括他本身。
     *
     * @param aspect
     * @return
     * @throws Exception
     */
    private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception {
        Set<Class<?>> targetClasSet = new HashSet<>();
        Class<? extends Annotation> annotation = aspect.value();
        if (annotation != null && !annotation.equals(Aspect.class)) {
            targetClasSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClasSet;
    }

    /**
     * 获取代理类，及其目标类集合之间的映射关系。
     * 一个代理类可以对应多个目标类。
     * 这里的代理类指的是切面类。
     *
     * @return
     * @throws Exception
     */
    private static Map<Class<?>, Set<Class<?>>> createProxMap() throws Exception {
        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<Class<?>, Set<Class<?>>>();
        //代理类
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
        for (Class<?> proxyClass : proxyClassSet) {
            Aspect aspect = proxyClass.getAnnotation(Aspect.class);
            if (null == aspect) continue;
            //代理类所对应的目标类的集合
            Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
            proxyMap.put(proxyClass, targetClassSet);
        }
        return proxyMap;
    }

    /**
     * 获得目标类和代理类的映射关系 生成List<Proxy>
     *
     * @param proxyMap
     * @return
     */
    private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
        Map<Class<?>, List<Proxy>> targetMap = new HashMap<Class<?>, List<Proxy>>();
        for (Map.Entry<Class<?>, Set<Class<?>>> proxyEntry : proxyMap.entrySet()) {
            Class<?> proxyClass = proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();
            for(Class<?> targetClass : targetClassSet) {
                Proxy proxy = (Proxy) proxyClass.newInstance();
                if(targetMap.containsKey(targetClass)) {
                    targetMap.get(targetClass).add(proxy);
                } else {
                    List<Proxy> proxyList = new ArrayList<>();
                    proxyList.add(proxy);
                    targetMap.put(targetClass, proxyList);
                }
            }
        }
        return targetMap;
    }
}
