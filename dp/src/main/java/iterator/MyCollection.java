package iterator;

/**
 * @author: omnifocus
 * @Date: 2020/7/15 5:23 PM
 * @Description: iterator
 * @version: 1.0
 */
public interface MyCollection<E> {
    void add(E o);

    int size();

    MyIterator iterator();
}
