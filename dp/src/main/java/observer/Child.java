package observer;

import java.util.List;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 10:11 AM
 * @Description: observer
 * @version: 1.0
 */
public class Child {
    String name;
    List<Observer> observers;

    public Child(String name, List<Observer> observers) {
        this.name = name;
        this.observers = observers;
    }

    void fireCryEvent() {
        System.out.println(name + " crying..");
        ChildEvent event = new ChildEvent(System.currentTimeMillis(), "home", this);
        for (Observer observer : observers) {
            observer.actionPerformed(event);
        }
    }

}


class Mom implements Observer {

    @Override
    public void actionPerformed(ChildEvent event) {
        System.out.println("mom hugging...." + event.getSource().name);
    }

}

class Dad implements Observer {

    @Override
    public void actionPerformed(ChildEvent event) {
        System.out.println("Dad feeding...." + event.getSource().name);
    }
}


