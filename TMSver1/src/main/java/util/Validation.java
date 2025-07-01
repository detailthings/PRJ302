/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static boolean checkUsername(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9._-]{4,30}$") || str.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean checkPassword(String str) {
        return str != null && str.length() >= 8;
    }

    public static String removeUnnecessaryBlank(String input) {
        return input.replaceAll("\\s+", " ");
    }

    public static boolean checkStringByRegex(String input, String regex) {
        return input != null && input.matches(regex);
    }

    public static boolean checkString(String input) {
        String cleanInput = removeUnnecessaryBlank(input);
        return checkStringByRegex(cleanInput, "[a-zA-Z0-9 ]+");
    }

    public static boolean checkYNOption(String input) {
        return input != null && input.matches("[yYnN]{1}");
    }

    public static String encryptionMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder(32);
        for (byte p : digest) {
            sb.append(String.format("%02x", p & 0xFF));
        }
        return sb.toString();
    }

    public static boolean checkEmail(String input) {
        return checkStringByRegex(input, "[\\w-.]+@[\\w-.]+\\.[a-zA-Z]{2,}");
    }

    public static boolean checkDate(String input) {
        if (input == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(input.trim());
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean checkName(String input) {
        return checkStringByRegex(input, "[a-zA-Z ]+");
    }

    public static boolean checkRequestID(String input) {
        return checkStringByRegex(input, "[a-zA-Z]{3}\\d{3}");
    }
    
    public static boolean checkTitle(String input) {
        return checkStringByRegex(input, "[a-zA-Z ]+");
    }

}
