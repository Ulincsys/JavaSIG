import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class ObservableList<T> implements List<T> {
	public List<Consumer<T>> listeners = new ArrayList<Consumer<T>>();
	
	public void onInsert(Consumer<T> consumer) {
		this.listeners.add(consumer);
	}
	
	public void notifyInsert(T obj) {
		for(var c : listeners) {
			c.accept(obj);
		}
	}
}
