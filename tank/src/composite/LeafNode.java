package composite;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 11:35 AM
 * @Description: composite
 * @version: 1.0
 */
public class LeafNode extends Node {
    public LeafNode(String name) {
        super(name);
    }

    @Override
    void p() {
        System.out.println("leafNode:" + name);
    }
}
