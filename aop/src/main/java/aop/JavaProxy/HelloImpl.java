package aop.JavaProxy;

/**
 * Created by jackeyChen on 2016/10/20.
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello" + name);
    }
}
