package staticproxy;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 7:00 PM
 * @Description: staticproxy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        //first log then time
//        new TimeProxy(new LogProxy(new Tank())).move();
        //first time then log
        new LogProxy(new TimeProxy(new Tank())).move();
    }
}
