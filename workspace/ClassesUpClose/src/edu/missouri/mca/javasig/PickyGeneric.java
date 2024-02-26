package edu.missouri.mca.javasig;

import java.util.List;

public class PickyGeneric<T, U extends T> {
public void example(List<? extends MySuperClass> l) {
	/* List is a generic type. In
	   this function, the generic
	   type of the instance must
	   be a subclass of MySuperClass
	*/
}
}
