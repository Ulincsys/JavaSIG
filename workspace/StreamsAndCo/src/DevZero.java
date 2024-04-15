import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DevZero {
	public static void main(String[] args) {
		Spliterator<Integer> split = Spliterators.spliterator(new NULL(), 0, Spliterator.NONNULL);
		Stream<Integer> devNull = StreamSupport.stream(split, false);
		
		System.out.println(devNull.findFirst().orElse(-1));
		
		Stream<Integer> gen = Stream.generate(() -> 0);
	}
}

class NULL implements Iterator<Integer> {
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Integer next() {
		return 0;
	}
}
