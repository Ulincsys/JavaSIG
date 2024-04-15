
public class Main {
	public static void main(String[] args) throws InterruptedException {
		String s = "I'm a messenger!";
		
		WakeUpThread t = new WakeUpThread(s);
		t.start();
		
		// Process your task
		Thread.sleep(5000);
		
		synchronized(s) {
			s.notifyAll();
		}
	}
}

class WakeUpThread extends Thread {
	private Object notifyObj;
	
	public WakeUpThread(Object o) {
		notifyObj = o;
	}
	
	@Override
	public void run() {
		System.out.println("Thread starting!");
		try {
			synchronized(notifyObj) {				
				notifyObj.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread exiting!");
	}
}