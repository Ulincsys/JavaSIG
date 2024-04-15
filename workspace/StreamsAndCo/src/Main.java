import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Integer[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Stream<Integer> s = Stream.of(arr);
				
		s.forEach((i) -> {
			System.out.println(i);
		});
	}
}
