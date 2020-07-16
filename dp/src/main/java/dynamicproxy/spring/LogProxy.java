package dynamicproxy.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 6:57 PM
 * @Description: dynamic proxy
 * @version: 1.0
 */
@Aspect
public class LogProxy {


    @Before("execution (void dynamicproxy.spring.Tank.move())")
    void before() {
        System.out.println("LogProxy.before");
    }

    @After("execution(void dynamicproxy.spring.Tank.move())")
    void after() {
        System.out.println("LogProxy.after");
    }
}

