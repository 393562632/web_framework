package aop.JavaProxy;

/**
 * Created by jackeyChen on 2016/10/20.
 */
public class InvockTest {

    public static void main(String[] args) {
        Hello proxy = (new DynamicProxy(new HelloImpl())).getProxy();
        proxy.say("start");
    }
}