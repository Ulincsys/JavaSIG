import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Examples {

	public static void main(String[] args) {
		List<Integer> l = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		System.out.println(l.stream().map((i) -> i * 2).toList());
		
		System.out.println(l.stream().filter((i) -> i % 2 == 0).toList());
		
		System.out.println(String.join(", ", l.stream().map((i) -> String.valueOf(i)).toArray(String[]::new)));
		
		var ints = Stream.generate(() -> ThreadLocalRandom.current().nextInt())
			.distinct()
			.filter((i) -> i % 2 == 0)
			.filter((i) -> i > 0)
			.limit(10)
			.toList();
		
		System.out.println(ints);
	}
}
