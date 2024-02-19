package edu.missouri.mca.javasig;

public enum MyEnum {
	ID_1(0),
	ID_2(1),
	ID_3(2),
	ID_4(3);
	
	int id;
	
	MyEnum(int id) {
		this.id = id;
		System.out.println("Initializing MyEnum constant with ID: " + id);
	}
}
