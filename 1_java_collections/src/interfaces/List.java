package interfaces;

import java.util.Iterator;
import java.util.ListIterator;

public interface List
{
	//index-based methods
	public void add(int index, Object element);
	public Object get(int index);
	public Object set(int index, Object element);
	public Object remove(int index);
	public int lastIndexOf(Object element);
	public List subList(int fromIndex, int toIndex);
	
	//basic methods
	public boolean add(Object element);
	public boolean remove(Object element);
	public boolean contains(Object element);
	public void clear();
	public int size();
	public boolean isEmpty();
	
	//set methods
	public boolean addAll(Collection other);
	public boolean addAll(int index, Collection other);
	public boolean containsAll(Collection other);
	public boolean removeAll(Collection other);
	public boolean retainAll(Collection other);
	
	//misc methods
	public boolean equals(Object other);
	public int hashcode();
	public Iterator iterator();
	public ListIterator listIterator();
	public ListIterator listIterator(int index);
	public Object[] toArray();
}

