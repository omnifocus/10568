package dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 7:00 PM
 * @Description: staticproxy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        LogProxy lp = new LogProxy(new Tank());
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Moveable moveable = (Moveable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Moveable.class}
            , new LogProxyInvocationHandle(lp));
        moveable.move();
        moveable.toString();
        System.out.println(moveable.hashCode());
    }
}
