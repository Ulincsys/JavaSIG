
public class NotifyWait extends Thread {
	int seconds;
	
	NotifyWait(int seconds) {
		this.seconds = seconds;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < seconds; ++i) {			
			try {
				this.wait();
				System.out.println("Awoken at second: " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
