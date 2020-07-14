package composite_flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 11:33 AM
 * @Description: composite
 * @version: 1.0
 */
public class BranchNode extends Node {
    List<Node> childNodes;

    public BranchNode(String name) {
        super(name);
        childNodes = new ArrayList<>();
    }

    @Override
    void p() {
        System.out.println("branch: " + name);
    }

    void addNode(Node node) {
        childNodes.add(node);
    }
}
