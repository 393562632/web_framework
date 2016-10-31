package aop.aspectJ.annotion.Introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by jackeyChen on 2016/10/31.
 */
@Aspect
@Component
public class GreetingIntroductionAspectJAspect {

    /**
     * 引介增强
     */
    @DeclareParents(value = "aop.aspectJ.annotion.Introduction.GreetingIntroductionImpl", defaultImpl = ApologyImpl.class)
    private Apology apology;

}
