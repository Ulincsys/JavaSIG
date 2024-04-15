import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessExample {

	public static void main(String[] args) {
		ProcessBuilder p = new ProcessBuilder("echo", "Hello, world!");
		
		try {
			Process r = p.start();
			
			InputStreamReader in = new InputStreamReader(r.getInputStream());
			BufferedReader read = new BufferedReader(in);
			
			System.out.println(r.exitValue());
			System.out.println(read.readLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
