package collections;

import java.util.Iterator;

public interface Collection
{
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
	public int hashCode();
	public Iterator iterator();
	public Object[] toArray();
}

