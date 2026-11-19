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
//初始运行优先级为Demo1->Demo2->Demo3
@Order(10)//修改运行优先级,数值越小优先级越高
//修改后运行优先级变成了Demo3->Demo2->Demo1
public class AspectDemo1 {
    @Before("org.example.springaopdemo.aspect.AspectDemo.pointCut()")
    public void doBefore() {
        log.info("Before running for AspectDemo1111");
    }

    @After("org.example.springaopdemo.aspect.AspectDemo.pointCut()")
    public void doAfter() {
        log.info("After running for AspectDemo1111");
    }

}
