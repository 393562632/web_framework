package com.study.framework.core.bean;

import com.study.framework.common.util.CastUtil;

import java.util.Map;

/**
 * Created by jackeyChen on 2016/9/30.
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取Long类型的数值
     *
     * @param name
     * @return
     */
    public long getLong(String name) {
        return CastUtil.castLong(name);
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }
}
