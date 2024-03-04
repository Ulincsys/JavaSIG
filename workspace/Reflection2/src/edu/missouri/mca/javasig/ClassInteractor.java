package edu.missouri.mca.javasig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ClassInteractor {
	ArrayList<Class<? extends Object>> classes = new ArrayList<Class<? extends Object>>();
	ArrayList<Object> instances = new ArrayList<Object>();
	
	BufferedReader stdin;
	PrintStream stdout = System.out;
	
	ClassInteractor() {
		classes.add(String.class);
		classes.add(Integer.class);
		
		this.stdin = new BufferedReader(new InputStreamReader(System.in));
	}
	
	@SafeVarargs
	ClassInteractor(Class<? extends Object> ... classes) {
		this();
		
		this.classes.addAll(Arrays.asList(classes));
	}
	
	void loop() {
		while(true) {
			String command = input();
			
			var args = command.split(" ");
			
			if(args.length < 1) {
				break;
			}
			
			switch(args[0].toLowerCase()) {
				case "call":
					break;
				case "callstatic":
					break;
				case "new":
					break;
				default:
					print("Unrecognized command[", args[0], "]");
			}
		}
	}
	
	void print(Object... args) {
		// A little preview of Streams and Co!
		stdout.println(String.join(" ", Arrays.stream(args).map(String::valueOf).toList()));
	}
	
	String input() {
		stdout.print("> ");
		try {
			return stdin.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
		return null;
	}
	
	String input(String msg) {
		stdout.print(msg);
		try {
			return stdin.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
		return null;
	}
	
	void printInstance(Integer i) {
		stdout.println(instances.get(i));
	}
}






































