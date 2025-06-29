/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {
    
     private static Scanner sc = new Scanner(System.in);
     
     public static boolean checkUsername(String str) {
         if (str != null) {
             if (str.matches("^[a-zA-Z0-9._-]{4,30}$") || str.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                 return true;
             } else {
                 return false;
             }
         } else {
             return false;
         }
     }
     
     public static boolean checkPassword(String str) {
         if(str!=null) {
             if(str.length()>=8) {
                 return true;
             } else {
                 return false;
             }
         } else {
             return false;
         }
     }

}
