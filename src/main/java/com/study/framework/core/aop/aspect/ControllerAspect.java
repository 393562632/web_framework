package com.study.framework.core.aop.aspect;

import com.study.framework.core.annotation.Aspect;
import com.study.framework.core.annotation.Controller;
import com.study.framework.core.aop.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by jackeyChen on 2016/11/1.
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);

    /**
     * 执行开始时间
     */
    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.debug("---------------------begin---------------------------");
        logger.debug(String.format("Class %s", cls.getName()));
        logger.debug(String.format("method %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        logger.debug(String.format("time %dms", System.currentTimeMillis() - begin));
        logger.debug("---------------------begin---------------------------");
    }
}
