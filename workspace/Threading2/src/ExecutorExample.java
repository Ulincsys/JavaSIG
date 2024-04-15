import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
	public static void main(String[] args) throws InterruptedException {
		// Create a thread pool with 3 threads
		var ex = Executors.newFixedThreadPool(3);
		
		// More tasks than there are threads!
		for(int i = 0; i < 10; ++i) {
			ex.submit(() -> {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hello! from " +
			        Thread.currentThread().getName());
			});
		}
		
		System.out.println("Done adding tasks!");
		
		// Must shut down pool or the threads will not exit
		ex.shutdown();
		ex.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		System.out.println("All tasks finished!");
	}
}
