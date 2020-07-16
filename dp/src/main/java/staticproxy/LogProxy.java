package staticproxy;

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
}
