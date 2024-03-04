import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Boolean b = hasMethod(MyPrivateClass.class, "isDecimal");
        System.out.println(b);
    }

    public static Boolean hasMethod(Class<?> o, String name) {
		for(Method m : o.getDeclaredMethods()) {
            System.out.println(m.getName());
			if(m.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}

class MyPrivateClass {
    private void isDecimal() {

    }
}