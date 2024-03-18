
public class MyThread extends Thread {
	@Override
	public void run() {
		// Thread entry point
		System.out.println("Hello from: " + this.getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Thread exit point
	}
}
