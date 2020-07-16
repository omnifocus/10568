package iterator;

/**
 * @author: omnifocus
 * @Date: 2020/7/15 5:29 PM
 * @Description: iterator
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        MyCollection<String> collection = new MyLinkedList();
        for (int i = 0; i < 15; i++) {
            collection.add("s" + i);
        }
        MyIterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
