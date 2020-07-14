package composite_flyweight;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 11:32 AM
 * @Description: composite
 * @version: 1.0
 */
public abstract class Node {
    String name;

    public Node(String name) {
        this.name = name;
    }

    abstract void p();
}
