package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mainMetod();
    }

    public static void mainMetod() {
        Operation operation = new Operation();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("         ************ Welcome to Arlen Bank *************");
            welcomOper();
            System.out.println("         ************ Welcome to Arlen Bank *************        ");
            System.out.print("Enter num: ");

            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    operation.createNewAccount();
                    break;
                case 2:
                    operation.operation2();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    static void  welcomOper() {
        System.out.println(
                "1.CreatnewAccount\n" +
                        "2.Chose Operation\n" +
                        "3.Exit ");

    
    }
}
