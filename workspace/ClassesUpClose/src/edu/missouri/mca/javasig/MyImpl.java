package edu.missouri.mca.javasig;

public class MyImpl extends MyAbstract {
	public MyImpl(int x) {
		// Can access non-private superclass members
		this.x = x;
	}
	
	public MyImpl() {
		super();
	}

	@Override
	void fun3() {
		
	}
}
