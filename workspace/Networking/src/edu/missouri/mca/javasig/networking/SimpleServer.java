package edu.missouri.mca.javasig.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	static ServerSocket s;
	
	public static void main(String[] args) throws IOException {
		s = new ServerSocket(54779);
		
		loop();
	}
	
	public static void loop() throws IOException {
		while(!s.isClosed()) {
			Socket client = s.accept();
			
			var in = new InputStreamReader(client.getInputStream());
			var reader = new BufferedReader(in);
			
			String line = reader.readLine();
			if(line.equals("exit")) {
				System.out.println("Exiting!");
				s.close();
			} else {
				System.out.println(line);
			}
			
			client.close();
		}
	}
}
