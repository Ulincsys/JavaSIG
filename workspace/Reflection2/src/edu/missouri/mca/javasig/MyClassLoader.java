package edu.missouri.mca.javasig;

public class MyClassLoader extends ClassLoader {
	public Class<?> tryLoadClass(String name) {
		try {
			return loadClass(name);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		MyClassLoader l = new MyClassLoader();
		
		Class<?> c = l.tryLoadClass("java.io.BufferedReader");
		System.out.println(String.valueOf(c));
	}
}
