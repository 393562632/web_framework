package com.study.framework.core.loader;

import com.study.framework.core.helper.Beanhelper;
import com.study.framework.core.helper.ClassHelper;
import com.study.framework.core.helper.ControllerHelper;
import com.study.framework.core.helper.IOCHelper;
import com.study.framework.core.util.ClassUtil;

/**
 * Created by jackeyChen on 2016/9/30.
 */
public class HelperLoader {
    public static void init() {
        Class<?>[] classList = {ClassHelper.class, Beanhelper.class, IOCHelper.class, ControllerHelper.class};
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
