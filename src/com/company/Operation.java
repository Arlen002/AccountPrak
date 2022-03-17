package com.company;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Operation extends Account{
    private String type;
    private double amount;
    private Date date;
    public Operation(){}
    public Operation(String type, double amount) {
        this.setType(type);
        this.setAmount(amount);
        this.setDate(new Date());
    }

    public void operation2(){
        System.out.print("Enter name: ");
        String nameat = sc.next();
        int counter = 0;
        for (String num:getNameArray()) {
            if (nameat.equalsIgnoreCase(num)) {
                int i = 1;
                System.out.print("Enter password: ");
                String password = sc.next();
                while (i <= 3) {
                    if (password.equals("Arlen001")) {
                        System.out.print("Enter pin: ");
                        String pincod = sc.next();
                        i++;
                        for (String pin2 : getPinArray()) {
                            if (pincod.equalsIgnoreCase(pin2)) {
                                System.out.println("<--************* Ваш аккаунт найден! *************-->");
                                operation(counter);
                            }
                        }
                        counter++;
                    }else {
                        System.out.println("«Данные введены неправильно»");
                        Main.mainMetod();
                    }
                }
            }
            System.out.println("\nYour account error?\n");
        }
    }

    public void  operation(int index){
        while (true) {
            showMenu();
            System.out.print("Enter number: ");
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    depositMain(index);break;
                case 2:
                    withdrawMethod(index);break;
                case 3:
                    showBalance();break;
                case 4:
                    transferMoney(index); break;
                case 5:
                    Main.mainMetod();
            }
        }
    }

    public void showMenu(){
        System.out.println(
                "1.Deposit\n" +
                        "2.Withdraw\n" +
                        "3.Balance\n" +
                        "4.TranswerMoney\n"+
                        "5.Exit\n"                  );
    }

    public String dateOperation(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String data = type+" "+ amount+" "+dateFormat.format(date);
        return  data;
    }
    public void translate(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
