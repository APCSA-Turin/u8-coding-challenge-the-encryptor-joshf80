package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if (messageLen == 0) {
            return 1;
        }
        return (messageLen + rows - 1) / rows;
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        String[][] encrypted = new String [rows][determineColumns(message.length(), rows)];

        int pos = 0;

        for (int i = 0; i < encrypted.length; i++) {
            for (int j = 0; j < encrypted[i].length; j++) {
                if (message.length() > pos) {
                    encrypted[i][j] = message.substring(pos, pos + 1);
                    pos ++;
                } else {
                    encrypted[i][j] = "=";
                }
            }
        }

        return encrypted;
    }

    public static String encryptMessage(String message, int rows){
        String[][] encryptedArray = generateEncryptArray(message, rows);

        String encryptedString = "";
        
            for (int c = encryptedArray[0].length - 1; c >= 0; c--) {
                for (int r = 0; r < encryptedArray.length; r++) {
                    encryptedString += encryptedArray[r][c];
                }
            }

        return encryptedString;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        int columns = determineColumns(encryptedMessage.length(), rows);

        if (rows * columns != encryptedMessage.length()) {
            return "Invalid rows";
        }

        String[][] decrypted = new String[rows][columns];
    
        int pos = 0;
    
        for (int c = columns - 1; c >= 0; c--) {
            for (int r = 0; r < rows; r++) {
                if (pos < encryptedMessage.length()) {
                    decrypted[r][c] = encryptedMessage.substring(pos, pos + 1);
                    pos++;
                }
            }
        }

        String decryptedString = "";
    
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (!decrypted[r][c].equals("=")) {
                    decryptedString += decrypted[r][c];
                }
            }
        }
    
        return decryptedString;
    }
}