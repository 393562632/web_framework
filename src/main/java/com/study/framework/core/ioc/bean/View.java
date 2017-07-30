package com.study.framework.core.ioc.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChenQiang on 2016/9/30.
 */
public class View {
    /**
     * 视图路径
     */
    private String path;

    /**
     *视图模型
     */
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        this.model = new HashMap<>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}