import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ReadGoogle {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("google.com", 80, null, 0);
		
		var in = new InputStreamReader(s.getInputStream());
		var reader = new BufferedReader(in);
		
		var out = new OutputStreamWriter(s.getOutputStream());
		var writer = new BufferedWriter(out);
		
		writer.write("""
GET / HTTP/1.1\r
Host: google.com\r
Connection: close\r
\r
\r
""");
		
		writer.flush();
		
		reader.lines().forEach(line -> {
			System.out.println(line);
		});
		
		s.close();
	}
}
