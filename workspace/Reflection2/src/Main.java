import edu.missouri.mca.javasig.ClassInteractor;

public class Main {

	public static void main(String[] args) {
		System.out.println(Main.class.getName());
		ClassInteractor c = new ClassInteractor(Main.class);
		
		c.loop();
	}
	
	public static void func() {
		System.out.println("Hello!");
	}
	
	public void func2(String msg) {
		System.out.println("MSG: " + msg);
	}
}
