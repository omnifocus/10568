package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 6:57 PM
 * @Description: staticproxy
 * @version: 1.0
 */
public class LogProxy implements Moveable {
    Moveable moveable;

    public LogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("begin move...");
        moveable.move();
        System.out.println("end move..");
    }

    @Override
    public void test() {
        System.out.println("LogProxy.test");
    }

}

class LogProxyInvocationHandle implements InvocationHandler {
    Moveable moveable;

    public LogProxyInvocationHandle(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        if (method.getName().equals("move")) {

        } else {
            System.out.println(method.getName());
        }
        obj = method.invoke(moveable, args);

        return obj;
    }


}
