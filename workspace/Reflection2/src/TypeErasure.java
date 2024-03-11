
public class TypeErasure {

	public static void main(String[] args) {
		try {
			var m = ErasedClass.class.getDeclaredMethods()[0];
			System.out.println(m.getName());
			for(var type : m.getParameterTypes()) {
				System.out.println(type.getName());
			}
			m.invoke(null, 5);
			
			// in main
			ErasureTest<Integer> test = new ErasureTest<Integer>();
			var m2 = ErasureTest.class.getDeclaredMethods()[0];
			m2.invoke(test, "test");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class ErasedClass {
	static <T extends Thread> void func(T t) {
		System.out.println(t.getClass().getName());
	}
	
	static <T> void func2(T t) {
		System.out.println(t.getClass().getName());
	}
}

class ErasureTest<T> {
	void func(T t) {
		System.out.println(t.getClass().getName());
	}
}
















