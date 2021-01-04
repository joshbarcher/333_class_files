package interfaces;

import java.util.Iterator;

public interface Queue
{
    //add to the queue
    public boolean offer(Object element);

    //remove from the queue
    public Object remove();
    public Object poll();

    //peek at the next element in the queue
    public Object element();
    public Object peek();

    //basic methods
    public boolean add(Object element);
    public boolean remove(Object element);
    public boolean contains(Object element);
    public void clear();
    public int size();
    public boolean isEmpty();

    //set methods
    public boolean addAll(Collection other);
    public boolean containsAll(Collection other);
    public boolean removeAll(Collection other);
    public boolean retainAll(Collection other);

    //misc methods
    public boolean equals(Object other);
    public int hashcode();
    public Iterator iterator();
    public Object[] toArray();
}

