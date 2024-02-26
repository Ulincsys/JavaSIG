package edu.missouri.mca.javasig;

public class GenFunc {
	public <XType> void print(XType o) {
		System.out.println(
				o.getClass().getName()
		);
	}
}
