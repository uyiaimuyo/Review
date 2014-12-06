import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Aysar on 12/5/2014.
 */
public class FlattenIterator<T> {

    Iterator<T> flatten(Iterator<Iterator<T>> iters) {
        final Queue<Iterator<T>> iteratorQ = new LinkedList<Iterator<T>>();
        while (iters.hasNext()) {
            iteratorQ.add(iters.next());
        }

        return new Iterator<T>() {
            public boolean hasNext() {
                if (iteratorQ.isEmpty()) {
                    return false;
                } else {
                    while (!iteratorQ.peek().hasNext()) {
                        iteratorQ.remove();
                        if (iteratorQ.isEmpty())
                            return false;
                    }
                }
                return true;

            }
            public T next() {
                if (hasNext()) {
                    Iterator<T> iterator = iteratorQ.remove();
                    iteratorQ.add(iterator);
                    return iterator.next();
                }
                throw new NullPointerException();
            }

            public void remove() {

            }
        };
    }
}
