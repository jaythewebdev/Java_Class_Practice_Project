package clsacctproject;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date datecreated;
    private Client client;
    private ArrayList<Transaction> transactions;

    //    public Account(){}
    public Account(int id,double balance,double annualInterestRate,Client client){
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=annualInterestRate;
        this.client=client;

        datecreated =new Date();
        this.transactions = new ArrayList<>();
    }

    public boolean withdraw(double amount){
        if(balance>=amount){
            balance-=amount;
            this.transactions.add(new Transaction('w',amount,this.balance,"Withdrawnn"+amount));
            return true;
        }
        return false;
    }
    public void deposit(double amount){
        balance+=amount;
        this.transactions.add(new Transaction('D',amount,this.balance,"Deposited"+amount));

    }

    public int countTransaction(char type){
        int count=0;
        for (Transaction transaction:transactions) {
            if (transaction.getType()==type)
                count++;
        }
        return count;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String toString(){
        return this.id+" "+this.balance+" "+this.annualInterestRate+" "+this.datecreated+"\n"+transactions;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDatecreated() {
        return datecreated;
    }
}
