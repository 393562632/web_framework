package com.study.framework.core.annotation;

import java.lang.annotation.*;

/**
 * Created by ChenQiang on 2016/11/1.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
