import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Examples {

	public static void main(String[] args) {
		List<Integer> l = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		System.out.println(l.stream().map((i) -> i * 2).toList());
		
		System.out.println(l.stream().filter(Examples::isEven).toList());
		
		System.out.println(String.join(", ", l.stream().map(String::valueOf).toArray(String[]::new)));
		
		var ints = Stream.generate(() -> {
			Integer i =
			ThreadLocalRandom.current().nextInt(25);
			System.out.println("Supplying random int: " + i);
			return i;
		})
			.distinct()
			.filter(Examples::isEven)
			.filter((i) -> {
				System.out.println("Checking positive: " + i);
				return i > 0;
			})
			.limit(10)
			.toList();
		
		System.out.println(ints);
	}

	public static Boolean isEven(Integer i) {
		System.out.println("Checking even: " + i);
		return i % 2 == 0;
	}
}
