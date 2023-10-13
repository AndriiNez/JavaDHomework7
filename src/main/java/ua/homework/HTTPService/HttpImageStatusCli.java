package ua.homework.HTTPService;

import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader downloader;

    public HttpImageStatusCli() {
        downloader = new HttpStatusImageDownloader();
    }

    public void askStatus() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code: ");
        boolean validInput = false;

        while (!validInput) {
            int statusCode = 0;

            try {
                statusCode = scanner.nextInt();
                downloader.downloadStatusImage(statusCode);
                System.out.println("Image downloaded successfully for status <" + statusCode + "> ");
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid number: ");
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("There is no image for HTTP status <" + statusCode + "> ");
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
