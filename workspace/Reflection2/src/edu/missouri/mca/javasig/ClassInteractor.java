package edu.missouri.mca.javasig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public class ClassInteractor {
	ArrayList<Class<? extends Object>> classes = new ArrayList<Class<? extends Object>>();
	ArrayList<Object> instances = new ArrayList<Object>();
	
	BufferedReader stdin;
	PrintStream stdout = System.out;
	
	public ClassInteractor() {
		classes.add(String.class);
		classes.add(Integer.class);
		
		this.stdin = new BufferedReader(new InputStreamReader(System.in));
	}
	
	@SafeVarargs
	public ClassInteractor(Class<? extends Object> ... classes) {
		this();
		
		this.classes.addAll(Arrays.asList(classes));
	}
	
	public void loop() {
		while(true) {
			String command = input();
			
			if(command == null) {
				// EOF entered (IE: CTRL + D)
				print("\nGoodbye!");
				return;
			}
			
			var args = command.split(" ");
			
			if(args.length < 1) {
				break;
			}
			
			outer: switch(args[0].toLowerCase()) {
				case "call":
					if(args.length < 2) {
						print("Must provide instance ref");
						break;
					} else if(args.length < 3) {
						print("Must provide function name");
					} else if(args.length < 4) {
						Object o = getInstance(args[1]);
						
						if(o == null) {
							break;
						}
						
						for(var m : o.getClass().getMethods()) {
							if(m.getName().equals(args[2])) {
								if(m.getParameterCount() != 0) {
									print("Skipping method: " + args[2] + "(" + String.join(", ", 
											Arrays.stream(m.getParameterTypes()).map(cl -> cl.getName()).toList())
									+ ")");
									continue;
								}
								try {
									Object ret = m.invoke(o);
									instances.add(ret);
									printInstance(instances.size() - 1);
									break outer;
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									break outer;
								}
							}
						}
						print("Method [" + args[2] + "] not found for class [" + args[1] + "]");
					} else {
						Object fnargs[] = new Object[args.length - 3];

						for(int i = 3; i < args.length; ++i) {
							if(args[i].startsWith("$")) {
								fnargs[i - 3] = getInstance(args[i]);
							} else {
								fnargs[i - 3] = args[i];
							}
						}
						
						Object o = getInstance(args[1]);
						
						if(o == null) {
							break;
						}
						
						for(var m : o.getClass().getMethods()) {
							if(m.getName().equals(args[2])) {
								print("Found method: " + args[2] + "(" + String.join(", ", 
										Arrays.stream(m.getParameterTypes()).map(cl -> cl.getName()).toList())
								+ ")");
								if(!input("Call this function?: ").toLowerCase().startsWith("y")) {
									print("Skipping");
									continue;
								}
								try {
									Object ret = m.invoke(o, fnargs);
									instances.add(ret);
									printInstance(instances.size() - 1);
									break outer;
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									break outer;
								}
							}
						}
						print("Method [" + args[2] + "] not found for class [" + args[1] + "]");
					}
					break;
				case "callstatic":
					if(args.length < 2) {
						print("Must provide class name");
						break;
					} else if(args.length < 3) {
						print("Must provide function name");
					} else if(args.length < 4) {
						Class<?> c = getByName(args[1]);
						
						if(c == null) {
							break;
						}
						
						for(var m : c.getMethods()) {
							if(m.getName().equals(args[2])) {
								if(m.getParameterCount() != 0) {
									print("Skipping method: " + args[2] + "(" + String.join(", ", 
											Arrays.stream(m.getParameterTypes()).map(cl -> cl.getName()).toList())
									+ ")");
									continue;
								}
								try {
									Object ret = m.invoke(null);
									instances.add(ret);
									printInstance(instances.size() - 1);
									break outer;
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									break outer;
								}
							}
						}
						print("Method with no arguments [" + args[2] + "] not found for class [" + args[1] + "]");
					} else {
						Object fnargs[] = new Object[args.length - 3];

						for(int i = 3; i < args.length; ++i) {
							if(args[i].startsWith("$")) {
								fnargs[i - 3] = getInstance(args[i]);
							} else {
								fnargs[i - 3] = args[i];
							}
						}
						
						Class<?> c = getByName(args[1]);
						
						if(c == null) {
							break;
						}
						
						for(var m : c.getMethods()) {
							if(m.getName().equals(args[2])) {
								print("Found method: " + args[2] + "(" + String.join(", ", 
										Arrays.stream(m.getParameterTypes()).map(cl -> cl.getName()).toList())
								+ ")");
								if(!input("Call this function?: ").toLowerCase().startsWith("y")) {
									print("Skipping");
									continue;
								}
								try {
									Object ret = m.invoke(null, fnargs);
									instances.add(ret);
									printInstance(instances.size() - 1);
									break outer;
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									break outer;
								}
							}
						}
						print("Method [" + args[2] + "] not found for class [" + args[1] + "]");
					}
					break;
				case "new":
					if(args.length < 2) {
						print("Must provide class name to instantiate");
						break;
					}
					var c = getByName(args[1]);
					if(c == null) {
						print("[" + args[1] + "]: class not found");
						break;
					}
					try {
						var constructor = c.getConstructor();
						Object o = constructor.newInstance();
						instances.add(o);
						printInstance(instances.size() - 1);
					} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "push":
					if(args.length < 2) {
						print("Must provide string to push");
						break;
					}
					instances.add(args[1]);
					break;
				case "print":
					if(args.length < 2 || !args[1].startsWith("$")) {
						print("Must provide instance ID: $#");
						break;
					}
					printInstance(args[1]);
					break;
				case "list":
					print("Instances(" + instances.size() + "):");
					for(int i = 0; i < instances.size(); ++i) {
						printInstance(i);
					}
					break;
				case "":
					break;
				default:
					print("Unrecognized command [", args[0], "]");
			}
		}
	}
	
	void print(Object... args) {
		// A little preview of Streams and Co!
		stdout.println(String.join(" ", Arrays.stream(args).map(String::valueOf).toList()));
	}
	
	Class<?> getByName(String name) {
		for(var c : classes) {
			if(c.getName().equals(name)) {
				return c;
			}
		}
		return null;
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
	
	Object getInstance(Integer i) {
		if(i < 0 || i >= instances.size()) {
			print("Invalid ref: $" + i);
			return null;
		}
		Object o = instances.get(i);
		return o;
	}
	
	Object getInstance(String i) {
		try {
			return getInstance(Integer.valueOf(i.substring(1)));
		} catch(NumberFormatException e) {
			print("[", i, "] was not understood as a ref");
		}
		return null;
	}
	
	void printInstance(Integer i) {
		if(i < 0 || i >= instances.size()) {
			print("Invalid ref: $" + i);
			return;
		}
		Object o = instances.get(i);
		print("$" + i + ":", o, "->", o != null ? o.getClass().getName() : "Null");
	}
	
	void printInstance(String i) {
		try {
			printInstance(Integer.valueOf(i.substring(1)));
		} catch(NumberFormatException e) {
			print("[", i, "] was not understood as a ref");
		}
	}
}






































