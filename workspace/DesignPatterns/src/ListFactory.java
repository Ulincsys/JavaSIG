import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListFactory {
	public <T> List<T> newList() {
		return new ArrayList<T>();
	}
	
	public <T> List<T> newList(int initialCapacity) {
		return new ArrayList<T>(initialCapacity);
	}
	
	public <T> List<T> newList(Boolean isSynchronized) {
		if(isSynchronized) {
			return Collections.synchronizedList(newList());
		}
		return newList();
	}
	
	public <T> List<T> newList(Boolean isSynchronized, Boolean fastAppend) {
		List<T> result;
		if(fastAppend) {
			result = new LinkedList<T>();
		} else {
			result = newList();
		}
		
		if(isSynchronized) {
			return Collections.synchronizedList(result);
		}
		return result;
	}
	
	public <T> List<T> newList(int initialCapacity, Boolean isSynchronized, Boolean fastAppend) {
		if(initialCapacity > 0 && fastAppend) {
			// Cannot fast-append to an arrayList
			throw new IllegalArgumentException("Cannot have fast-append in a list with initial capacity");
		} else if(initialCapacity > 0 && isSynchronized) {
			return new Vector<T>(initialCapacity);
		} else if(initialCapacity > 0) {
			return newList(initialCapacity);
		}
		
		return newList(isSynchronized, fastAppend);
	}
}




























