package ua.homework.HTTPService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusImageDownloaderTest {
    private HttpStatusImageDownloader downloader;

    @BeforeEach
    public void BeforeEach() {
        downloader = new HttpStatusImageDownloader();
    }

    @Test
    public void testDownloadStatusImageSuccess() throws Exception {

        int code = 300;
        downloader.downloadStatusImage(code);
        String folderPath = "./images";
        String fileName = code + ".jpg";
        Path filePath = Path.of(folderPath, fileName);

        assertTrue(Files.exists(filePath));
    }

    @Test
    public void testDownloadStatusImageFailure() {
        // Перевірка невдачі завантаження картинки (наприклад, невірний код статусу)
        assertThrows(Exception.class, () -> downloader.downloadStatusImage(9999));
    }

}