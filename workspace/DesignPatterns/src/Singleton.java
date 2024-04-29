public class Singleton {
	private static Singleton instance;
	
	private Singleton() {
		// Cannot be externally instantiated
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		
		return instance;
	}
}