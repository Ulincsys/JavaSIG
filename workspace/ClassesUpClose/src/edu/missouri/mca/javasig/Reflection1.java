package edu.missouri.mca.javasig;

import java.lang.reflect.Method;

public class Reflection1 {
	public Boolean hasMethod(Object o, String name) {
		for(Method m : o.getClass().getDeclaredMethods()) {
			if(m.getName() == name) {
				return true;
			}
		}
		return false;
	}
}
