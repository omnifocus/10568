package iterator;

/**
 * @author: omnifocus
 * @Date: 2020/7/15 4:57 PM
 * @Description: iterator
 * @version: 1.0
 */
public class MyArrayList<E> implements MyCollection<E> {
    E[] objs;
    int size;

    public MyArrayList(int len) {

//        objs = new E [len]; error Type parameter 'E' cannot be instantiated directly
        objs = (E[]) new Object[len];
    }

    public MyArrayList() {
        this(2);
    }

    public void add(E o) {
        if (size == objs.length) {
            E[] newobjs = (E[]) new Object[objs.length * 2];
            System.arraycopy(objs, 0, newobjs, 0, objs.length);
            objs = newobjs;
        }

        objs[size++] = o;
    }


    public int size() {
        return size;
    }


    private class ArrayListIterator implements MyIterator {
        int iterateIndex = 0;

        @Override
        public boolean hasNext() {
            if (iterateIndex == size - 1)
                return false;
            return true;
        }

        @Override
        public E next() {
            return objs[iterateIndex++];
        }
    }

    public MyIterator iterator() {
        return new ArrayListIterator();
    }
}
