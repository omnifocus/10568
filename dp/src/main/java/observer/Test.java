package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 10:18 AM
 * @Description: observer
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Observer mom = new Mom();
        Observer dad = new Dad();
        List<Observer> observers = new ArrayList<>();
        observers.add(mom);
        observers.add(dad);
        Child child = new Child("panda", observers);
        child.fireCryEvent();
    }
}
