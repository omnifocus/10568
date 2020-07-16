package iterator;

/**
 * @author: omnifocus
 * @Date: 2020/7/15 5:33 PM
 * @Description: iterator
 * @version: 1.0
 */
public interface MyIterator<E> {
    boolean hasNext();

    E next();
}
