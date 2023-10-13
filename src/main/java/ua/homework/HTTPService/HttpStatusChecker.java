package ua.homework.HTTPService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public String getStatusImage(int code) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http.cat/" + code + ".jpg"))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 404) {
            throw new Exception("Image not found for status code: " + code);
        }

        return "https://http.cat/" + code + ".jpg";
    }

}
