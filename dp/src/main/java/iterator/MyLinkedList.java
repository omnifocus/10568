package iterator;

/**
 * @author: omnifocus
 * @Date: 2020/7/15 5:02 PM
 * @Description: iterator
 * @version: 1.0
 */
public class MyLinkedList<E> implements MyCollection<E> {
    // if not record tail, each time adds an object, iterate from head till last ,then add
    // if record tail, get tail directly and add it.
    Node head, tail;
    // if not record size, have to iterate from first to last
    // if record size, get size directly
    int size;


    public void add(E o) {
        Node node = new Node(o, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {

            tail.next = node; // tail -> next  =  head -> next
            tail = node;
        }
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator();
    }


    class MyLinkedListIterator implements MyIterator {
        Node iterateNode = head;

        @Override
        public boolean hasNext() {
            if (iterateNode == null)
                return false;
            return true;
        }

        @Override
        public E next() {
            E o = iterateNode.o;
            iterateNode = iterateNode.next;
            return o;
        }
    }

    class Node {
        E o;
        Node next;

        public Node(E o, Node next) {
            this.o = o;
            this.next = null;
        }
    }


}
