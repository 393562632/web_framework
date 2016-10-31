package aop.aspectJ.annotion.Introduction;

import aop.aspectJ.annotion.Hello;
import aop.aspectJ.annotion.Tag;
import org.springframework.stereotype.Component;

/**
 * Created by jackeyChen on 2016/10/31.
 */
@Component
public class GreetingIntroductionImpl implements Hello {

    @Tag
    @Override
    public void say(String name) {
        System.out.println("say....." + name);
    }

    public void goodMorning(String name) {
        System.out.println("goodMorning ....." + name);
    }

    public void goodNight(String name) {
        System.out.println("goodAfterNight ....." + name);
    }
}
