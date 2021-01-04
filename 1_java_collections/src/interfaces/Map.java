package interfaces;

public interface Map
{
	//insertion and removal
	public Object put(Object key, Object value);
	public Object get(Object key);
	public Object remove(Object key);
	public void clear();
	
	//search
	public boolean containsKey(Object key);
	public boolean containsValue(Object value);
	public int size();
	public boolean isEmpty();
	
	//traversal
	public Set keyset();
	public Collection values();
	
	//misc
	public boolean equals(Object other);
	public int hashcode();
}

