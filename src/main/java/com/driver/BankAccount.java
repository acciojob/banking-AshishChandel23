package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }
    static void findNDigitNumsUtil(int n, int sum, char out[], int index)
    {
        if (index > n || sum < 0)
            return;

        if (index == n)
        {
            if(sum == 0)
            {
                out[index] = '\0'   ;
                System.out.print(out);
                System.out.print(" ");
            }
            return;
        }
        for (int i = 0; i <= 9; i++)
        {
            out[index] = (char)(i + '0');
            findNDigitNumsUtil(n, sum - i, out, index + 1);
        }
    }
    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        char[] out = new char[digits + 1];

        for (int i = 1; i <= 9; i++)
        {
            out[0] = (char)(i + '0');
            findNDigitNumsUtil(digits, sum - i, out, 1);
        }
        int currentSum=0;
        for(int i=0;i< out.length;i++){
            currentSum+= Integer.valueOf(out[i]);
        }
        if(currentSum!=sum){
            throw new RuntimeException("Account Number can not be generated");
        }
        return String.valueOf(out);
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance-amount < this.minBalance){
            throw new RuntimeException("Insufficient Balance");
        }
        this.balance-=amount;
    }

}