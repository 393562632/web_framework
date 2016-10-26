package aop.cglibProxy;

/**
 * Created by jackeyChen on 2016/10/25.
 */
public class Client {

    public static void main(String[] args) throws Exception {
       Hello hello =  CGLibDynamicProxy.getInstance().getProxy(HelloImpl.class);
       hello.say("Hello CGlib Proxy");
    }
}
