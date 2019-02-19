import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class PeekingIterator<E> implements Iterator<E> {

    E p = null;
    Iterator<E> it;
	public PeekingIterator(Iterator<E> iterator) {
        it = iterator;
        if(it.hasNext()) p = it.next();
	}

	public E peek() {
        return p;
	}

	@Override
	public E next() {
        E ret = p;
        if(it.hasNext()) p = it.next();
        else p = null;
        return ret;
	}

	@Override
	public boolean hasNext() {
	    return p != null;
    }
    
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3);
        PeekingIterator<Integer> test = new PeekingIterator<>(l.iterator());
        System.out.println(test.next());
        System.out.println(test.peek());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.hasNext());
    }
}