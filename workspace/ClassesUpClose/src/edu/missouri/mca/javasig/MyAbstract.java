package edu.missouri.mca.javasig;

public abstract class MyAbstract {
	int x = 0;
	
	public MyAbstract() {
		this.x = 0;
	}
	
	public void fun() {
		System.out.println("abstract public impl");
	}
	
	private void fun2() {
		System.out.println("abstract private impl");
	}
	
	// Cannot be private
	abstract void fun3();
}
