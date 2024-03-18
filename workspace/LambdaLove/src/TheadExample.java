
public class TheadExample {

	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {
			int x = 0;
			while(x <= 5) {
				System.out.println(5);
				++x;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		};
		
		Thread t = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		
		t.start();
		t2.start();
		t3.start();
		t.start();
	}
}
