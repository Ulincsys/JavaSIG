import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class WhatsMyIP {
	public static void main(String[] args) {
		var builder = HttpRequest.newBuilder();
		var client = HttpClient.newHttpClient();
		
		var request = builder.uri(URI.create("http://icanhazip.com")).GET().build();
		
		try {
			var response = client.send(request, BodyHandlers.ofString());
			if(response.statusCode() != 200) {
				throw new RuntimeException("Request failed with: " + response.statusCode());
			}
			System.out.println(response.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
