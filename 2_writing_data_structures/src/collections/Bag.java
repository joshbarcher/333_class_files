package collections;

import java.util.Iterator;

public class Bag implements Collection
{
    private Object[] data;
    private int nextIndex = 0;
    private int capacity;

    public Bag(int capacity)
    {
        this.capacity = capacity;
        this.data = new Object[capacity];
    }

    @Override
    public boolean add(Object element)
    {
        if (nextIndex == capacity)
        {
            return false;
        }
        data[nextIndex++] = element;
        return true;
    }

    @Override
    public boolean contains(Object element)
    {
        //loop until the last used index
        for (int i = 0; i < nextIndex; i++)
        {
            //use equals() to determine if we
            //found the element
            if (data[i].equals(element))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size()
    {
        return nextIndex;
    }

    @Override
    public boolean isEmpty()
    {
        return nextIndex == 0;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public boolean remove(Object element)
    {
        return false;
    }

    @Override
    public Iterator iterator()
    {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public boolean addAll(Collection other)
    {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public boolean containsAll(Collection other)
    {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public boolean removeAll(Collection other)
    {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public boolean retainAll(Collection other)
    {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public int hashCode()
    {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public Object[] toArray()
    {
        throw new UnsupportedOperationException("Operation not supported");
    }
}

