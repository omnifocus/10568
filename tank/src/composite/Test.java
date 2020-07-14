package composite;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 11:36 AM
 * @Description: composite
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        LeafNode c11 = new LeafNode("c11");
        LeafNode c12 = new LeafNode("c12");
        BranchNode chapter2 = new BranchNode("chapter2");
        BranchNode chapter21 = new BranchNode("chapter21");
        LeafNode c211 = new LeafNode("c211");
        LeafNode c212 = new LeafNode("c212");
        BranchNode chapter3 = new BranchNode("chapter3");

        root.addNode(chapter1);
        root.addNode(chapter2);
        chapter1.addNode(c11);
        chapter1.addNode(c12);
        chapter2.addNode(chapter21);
        chapter21.addNode(c211);
        chapter21.addNode(c212);
        root.addNode(chapter3);

        print(root, 0);

    }

    static void print(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        node.p();
        if (node instanceof BranchNode) {
            for (Node n : ((BranchNode) node).childNodes) {
                print(n, depth + 1);
            }
        }

    }
}
