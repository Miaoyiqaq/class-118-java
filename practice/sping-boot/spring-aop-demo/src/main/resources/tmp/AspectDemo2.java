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
@Order(1)
public class AspectDemo2 {
    @Before("org.example.springaopdemo.aspect.AspectDemo.pointCut()")
    public void doBefore() {
        log.info("Before running for AspectDemo2222");
    }

    @After("org.example.springaopdemo.aspect.AspectDemo.pointCut()")
    public void doAfter() {
        log.info("After running for AspectDemo2222");
    }

}
