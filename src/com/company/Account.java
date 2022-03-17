package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Account {
    Scanner sc = new Scanner(System.in);
    private double balance;
    private String[] accHolderName;
    private String[] accHolderPhoneNo;
    private double withdrawAmount;
    private boolean accountExists;
    private String accHolderIFSCCode;
    private Operation operation;
    private int[] deposit;
    private String[] nameArray = {};
    private String[] pinArray = {};
    private int [] sumArray = {};

    static final double MINIMUM_BALANCE = 1000.0;
    static final double DAILY_WITHDRAW_LIMIT = 5000.0;

    public Account(){
        this.balance=0;
        this.withdrawAmount = 0.0;
        this.accountExists = false;
    }
    public String[] nameArray() {
        while (true) {
            System.out.print("Enter name: ");
            String name = sc.next();
            if (!name.matches("[A-Z a-z]*$")) {
                System.out.println("Error?");
            } else {
                nameArray = Arrays.copyOf(nameArray, nameArray.length + 1);
                nameArray[nameArray.length - 1] = name;
                return nameArray;
            }
        }
    }

    public String[]pinArray(){
        System.out.print("Enter pin: ");
        String pin = sc.next();
        pinArray = Arrays.copyOf(pinArray,pinArray.length + 1);
        pinArray[pinArray.length - 1] = pin;
        return pinArray;
    }
    public int [] sumArray(){
        int sum = readDeposit();
        sumArray = Arrays.copyOf(sumArray,sumArray.length + 1);
        sumArray[sumArray.length - 1] = sum;
        return sumArray;
    }

    void createNewAccount() {
        getUserDetails();
    }
    void getUserDetails() {
        accHolderName = nameArray();
        accHolderPhoneNo = pinArray();
        warningMessage();
        deposit = sumArray();
        setAccountExists(true);
        accountCreatedMessage();

    }
    void depositMain( int index) {
        int depositEnter = readDeposit();
        int san = sumArray[index];
        depositEnter += san;
        sumArray[index] = depositEnter;
        System.out.println("Баланс: "+ sumArray[index]);
        System.out.println(" <---***************** Add deposit Successful ******************---> ");
        Operation operation = new Operation("Deposit", depositEnter);
        System.out.println(operation.dateOperation());
    }
    void withdrawMethod(int index) {

        System.out.print(" Enter withdraw: ");
        int withdrawEnter = sc.nextInt();
        if (withdrawEnter >= DAILY_WITHDRAW_LIMIT) {
            System.out.println("\nDAILY_WITHDRAW_LIMIT = 5000.0\n");
        } else {
            sumArray[index] = sumArray[index] - withdrawEnter;
            System.out.println("Баланс : " + sumArray[index]);
            System.out.println("<----------------------------------------------------------------------------------------->");
            Operation operationWithdraw = new Operation("Withdraw", withdrawEnter);
            System.out.println(operationWithdraw.dateOperation());

        }
    }
    void accountCreatedMessage() {
        System.out.println("<----------------------------------------------------------------------------------------->");
        System.out.println(" <*************** Account created successuful *****************>");
        System.out.println("<----------------------------------------------------------------------------------------->");
    }

    void warningMessage() {
        System.out.println("<----------------------------------------------------------------------------------------->");
        System.out.println("\nMINIMUM_BALANCE = 1000\n DAILY_WITHDRAW_LIMIT: 5000");
        System.out.println("<----------------------------------------------------------------------------------------->");

    }
    int readDeposit() {
        while (true) {
            System.out.println("<----------------------------------------------------------------------------------------->");
            System.out.print("  Enter deposit: ");
            int sum = sc.nextInt();
            if (sum >= MINIMUM_BALANCE) {
                System.out.println("<----------------------------------------------------------------------------------------->");
                return sum;
            } else {
                System.out.println("\nMINIMUM_BALANCE = 1000.0\n");
            }
        }
    }

    public void  transferMoney(int index){
        System.out.println("Enter transfer: ");
        int trans  = sc.nextInt();
        int sun = sumArray[index];
        sun = sun - trans;
        sumArray[index] = sun;
        System.out.println("Enter to hum transfer the money: ");
        String  nameMoney = sc.next();
        for (int i = 0; i < nameArray.length; i++) {
            if (nameMoney.equalsIgnoreCase(nameArray[i])){
                int array = sumArray[i];
                array = array + trans;
                sumArray[i] = array;
                Operation operation = new Operation("transfer",trans);
                System.out.println(operation.dateOperation());
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    void showBalance() {
        System.out.println("<----------------------------------------------------------------------------------------->");
        System.out.print("    Total your balance is: --> ");
        System.out.println(Arrays.toString(getSumArray()));
        System.out.println("<----------------------------------------------------------------------------------------->");
    }

    public String[] getNameArray() {
        return nameArray;
    }

    public void setNameArray(String[] nameArray) {
        this.nameArray = nameArray;
    }

    public String[] getPinArray() {
        return pinArray;
    }

    public void setPinArray(String[] pinArray) {
        this.pinArray = pinArray;
    }

    public int[] getSumArray() {
        return sumArray;
    }

    public void setSumArray(int[] sumArray) {
        this.sumArray = sumArray;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String[] getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String[] accHolderName) {
        this.accHolderName = accHolderName;
    }

    public String[] getAccHolderPhoneNo() {
        return accHolderPhoneNo;
    }

    public void setAccHolderPhoneNo(String[] accHolderPhoneNo) {
        this.accHolderPhoneNo = accHolderPhoneNo;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public boolean isAccountExists() {
        return accountExists;
    }

    public void setAccountExists(boolean accountExists) {
        this.accountExists = accountExists;
    }

    public String getAccHolderIFSCCode() {
        return accHolderIFSCCode;
    }

    public void setAccHolderIFSCCode(String accHolderIFSCCode) {
        this.accHolderIFSCCode = accHolderIFSCCode;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int[] getDeposit() {
        return deposit;
    }

    public void setDeposit(int[] deposit) {
        this.deposit = deposit;
    }

    public static double getMinimumBalance() {
        return MINIMUM_BALANCE;
    }

    public static double getDailyWithdrawLimit() {
        return DAILY_WITHDRAW_LIMIT;
    }

    @Override
    public String toString() {
        return "Account{" +
                "nameArray=" + Arrays.toString(nameArray) +
                ", pinArray=" + Arrays.toString(pinArray) +
                ", sumArray=" + Arrays.toString(sumArray) +
                '}';
    }
}
