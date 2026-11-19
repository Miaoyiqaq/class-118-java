package tmp;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(-10)
public class AspectDemo3 {
    @Before("org.example.springaopdemo.aspect.AspectDemo.pointCut()")
    public void doBefore() {
        log.info("Before running for AspectDemo3333");
    }

    @After("org.example.springaopdemo.aspect.AspectDemo.pointCut()")
    public void doAfter() {
        log.info("After running for AspectDemo3333");
    }

}
