package dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: omnifocus
 * @Date: 2020/7/15 10:56 AM
 * @Description: dynamicproxy.cglib
 * @version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);

        TankMethodInterceptor tmi = new TankMethodInterceptor();
        enhancer.setCallback(tmi);

        Tank tankProxy = (Tank) enhancer.create();
        tankProxy.move();
    }
}

class TankMethodInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = null;
        start();
        obj = methodProxy.invokeSuper(o, objects);
//        System.out.println(method.getName() + " ----methodproxy: " + methodProxy.getSignature());
        end();
        return obj;
    }

    void start() {
        System.out.println("TankMethodInterceptor.start");
    }

    void end() {
        System.out.println("TankMethodInterceptor.end");
    }
}
