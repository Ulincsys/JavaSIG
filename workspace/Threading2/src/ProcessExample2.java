import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class ProcessExample2 {

	public static void main(String[] args) {
		ProcessBuilder p0 = new ProcessBuilder("uname", "-a");
		ProcessBuilder p1 = new ProcessBuilder("cut", "-d", " ", "--fields=1");
		
		try {
			List<Process> ps = ProcessBuilder.startPipeline(List.of(p0, p1));
			
			Process px = ps.get(1);
			
			InputStreamReader in = new InputStreamReader(px.getInputStream());
			BufferedReader read = new BufferedReader(in);
			
			px.waitFor();
			
			System.out.println(px.exitValue());
			System.out.println(read.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
