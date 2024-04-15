import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class RandGen {
	public static void main(String[] args) {
		Stream<Integer> generator = Stream.generate(() -> {
			return ThreadLocalRandom.current().nextInt();
		});
		
		generator.limit(10).forEach((i) -> {
			System.out.println(i);
		});
	}
}
