import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Consumer<String> fn = FnTest::func;
		fn.accept("Test");
		
		InstTest i = new InstTest();
		Consumer<String> fn2 = i::func;
		
		IFunc k = new ImplTest();
		call("Test", k::func);
		
		var fn3 = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		
		Consumer<String> fn4 = (s) -> {
			System.out.println(s);
		};
		
		System.out.println(executeFn(10, (n) -> {
			return n * 7;
		}));
	}
	
	public static Number executeFn(Integer n, IMultiplyBySeven<Integer, Number> fn) {
		return fn.perform(n);
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