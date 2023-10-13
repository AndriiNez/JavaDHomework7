package ua.homework.HTTPService;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        if (imageUrl == null) {
            throw new Exception("Image not found for status code: " + code);
        }

        String folderPath = "./images";
        String fileName = code + ".jpg";
        Path filePath = Path.of(folderPath, fileName);

        try (InputStream in = new URL(imageUrl).openStream()) {
            Files.copy(in, filePath);
        } catch (IOException e) {
            throw new Exception("Failed to download the image for status code: " + code, e);
        }
    }
}
