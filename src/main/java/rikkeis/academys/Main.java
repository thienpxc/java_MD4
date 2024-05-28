package rikkeis.academys;

import java.util.Scanner;
import rikkeis.academys.QuadraticEquation;
import rikkeis.academys.InputValidator;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true){
           System.out.println("1. Bai tap 1");
            System.out.println("2. Bai tap 2");
            System.out.println("3. Thoat");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Ban da chon bai tap 1");

                    QuadraticEquation.main(null);
                break;
                case 2:
                    System.out.println("Ban da chon bai tap 2");
                    InputValidator.main(null);
                    break;

                default:
                    System.out.println("Ban da chon sai, vui long chon lai");
                    break;
            }
        }
    }
}