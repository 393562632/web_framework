package aop.aspectJ.annotion.Introduction;

import org.springframework.stereotype.Component;

/**
 * Created by jackeyChen on 2016/10/31.
 */
@Component
public class ApologyImpl implements Apology {
    @Override
    public void sqySorry(String name) {
        System.out.println("Sorry" + name);
    }
}
