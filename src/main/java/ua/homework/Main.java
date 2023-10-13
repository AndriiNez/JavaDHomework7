package ua.homework;

import ua.homework.HTTPService.HttpImageStatusCli;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}