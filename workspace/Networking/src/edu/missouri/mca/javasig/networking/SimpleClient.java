package edu.missouri.mca.javasig.networking;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String lines[] = {
				"Hello, world!",
				"This is another connection",
				"I'm going to quit now",
				"exit"
		};
		
		for(var line : lines) {
			Socket s = new Socket("127.0.0.1", 54779);
			
			var out = new OutputStreamWriter(s.getOutputStream());
			var writer = new PrintWriter(out);
			
			writer.format("%s\n", line);
			// Or you can enable automatic flushing
			writer.flush();
			s.close();
		}
	}
}
