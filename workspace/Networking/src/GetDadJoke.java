import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.JsonParser;

public class GetDadJoke {
	public static void main(String[] args) {
		var builder = HttpRequest.newBuilder();
		var client = HttpClient.newHttpClient();
		
		var request = builder.uri(URI.create("https://icanhazdadjoke.com")).GET()
				.header("Accept", "application/json")
				.header("User-Agent", "Java/Networking Demo").build();
		
		try {
			var response = client.send(request, BodyHandlers.ofInputStream());
			
			var in = new InputStreamReader(response.body());
			var obj = JsonParser.parseReader(in);
			
			System.out.println(obj);
			
			String joke = obj.getAsJsonObject().get("joke").getAsString();
			System.out.println(joke);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
