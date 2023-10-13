package ua.homework.HTTPService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusCheckerTest {
    private HttpStatusChecker statusChecker;


    @BeforeEach
    public void beforeEach() {
        statusChecker = new HttpStatusChecker();
    }

    @Test
    public void testThanGetStatusImage() throws Exception {
        int code = 200;
        String status = statusChecker.getStatusImage(code);
        Assertions.assertEquals("https://http.cat/" + code + ".jpg", status);
    }

    @Test
    public void testThanGetStatusImageNotExist() throws Exception {
        Assertions.assertThrows(Exception.class, () -> {
            statusChecker.getStatusImage(208);
        });
    }

}