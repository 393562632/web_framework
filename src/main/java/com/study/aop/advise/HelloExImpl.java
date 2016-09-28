package com.study.aop.advise;

import org.springframework.stereotype.Component;

/**
 * Created by ChenQiang on 2016/10/25.
 */
@Component
public class HelloExImpl implements HelloEx {

    @Override
    public void say(String name) throws Exception {
        System.out.println("say......." + name);
        throw new Exception("error");
    }
}
