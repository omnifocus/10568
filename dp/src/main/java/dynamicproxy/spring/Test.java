package dynamicproxy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * @author: omnifocus
 * @Date: 2020/7/15 12:07 PM
 * @Description: dynamicproxy.spring
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        Tank tank = (Tank) ctx.getBean("tank");
        tank.move();

        System.out.println(UUID.randomUUID());
    }
}
