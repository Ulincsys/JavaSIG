import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		runMyThreads();
	}
	
	static void runMyThreads() throws IOException {
		ArrayList<MyThread> threads = new ArrayList<MyThread>();
		
		System.out.println("Before creation");
		
		System.in.read();
		
		for(int i = 0; i < 20; ++i) {
			threads.add(new MyThread());
		}
		
		System.out.println("After creation");
		
		System.in.read();
		
		for(var t : threads) {
			t.start();
		}
	}
	
	static void runLambdaThreads() throws IOException {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		System.out.println("Before creation");
		
		System.in.read();
		
		for(int i = 0; i < 20; ++i) {
			threads.add(new Thread(() -> {
				// Thread entry point
				System.out.println("Hello from: " + Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Thread exit point
			}));
		}
		
		System.out.println("After creation");
		
		System.in.read();
		
		for(var t : threads) {
			t.start();
		}
	}
}
