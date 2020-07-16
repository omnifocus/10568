package dynamicproxy.cglib;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 6:56 PM
 * @Description: staticproxy
 * @version: 1.0
 */
public class Tank {

    void move() {
        System.out.println("Tank.move");
    }

    void fire(int num) {
        System.out.println("fire " + num + "bullets!");
    }
}

