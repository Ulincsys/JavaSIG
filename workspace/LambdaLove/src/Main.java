import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Consumer<String> fn = FnTest::func;
		fn.accept("Test");
		
		InstTest i = new InstTest();
		Consumer<String> fn2 = i::func;
		
		IFunc k = new ImplTest();
		call("Test", k::func);
	}
	
	public static void call(String s, Consumer<String> fn) {
		fn.accept(s);
	}
}

class ImplTest implements IFunc {
	@Override
	public void func(String s) {
		System.out.println(s);
	}
}

class InstTest {
	void func(String s) {
		System.out.println(s);
	}
}

class FnTest {
	static void func(String s) {
		System.out.println(s);
	}
}