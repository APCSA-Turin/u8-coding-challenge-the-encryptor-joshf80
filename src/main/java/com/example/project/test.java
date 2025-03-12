package com.example.project;

public class test {
    public static void main(String[] args) {
        String message = "HELLOWORLD";
        int rows = 2;
        String[][] expected = {
            {"H", "E", "L", "L", "O"},
            {"W", "O", "R", "L", "D"}
        };

        System.out.println(Encryptor.determineColumns(message.length(), rows));

        String[][] encrypted = Encryptor.generateEncryptArray(message, rows);
        for (String[] strings : encrypted) {
            for (String str : strings) {
                System.out.print(str + "|");
            }
            System.out.println();
        }
    }
}
