package xsir;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer last;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (last == null) {
            last = iter.next();
        }
        return last;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (last == null) {
            return iter.next();
        }
        Integer tmp = last;
        last = null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return last != null || iter.hasNext();
    }
}
