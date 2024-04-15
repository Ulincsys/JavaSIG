import java.util.concurrent.ThreadLocalRandom;

public class MultiUnsyncPrint {
	public static void main(String[] args) throws InterruptedException {
		StringBuilder b = new StringBuilder();
		
		Thread[] array = new Thread[10];
		
		for(int i = 0; i < 10; ++i) {
			var t = new MyPrinter(b);
			array[i] = t;
		}
		
		for(Thread t : array) {
			t.start();
		}
		
		for(Thread t : array) {
			t.join();
		}
		
		System.out.print(b.toString());
	}
}

class MyPrinter extends Thread {
	StringBuilder builder;
	
	public MyPrinter(StringBuilder b) {
		builder = b;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; ++i) {
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(5));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(builder) {				
				builder.append(i + ": Hello, world! This is a very long string with a lot of characters that was created to demonstrate the fact that calling functions in Java is not a synchronized operation, and that concurrent access to an object instance can be dangerous.\n");
			}
		}
	}
}