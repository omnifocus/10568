package dynamicproxy;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 6:58 PM
 * @Description: staticproxy
 * @version: 1.0
 */
public class TimeProxy implements Moveable {
    Moveable moveable;

    public TimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        moveable.move();
        long interval = System.currentTimeMillis() - start;
        System.out.println("takes " + interval + " milliseconds!");
    }

    @Override
    public void test() {
        System.out.println("TimeProxy.test");
    }
}
