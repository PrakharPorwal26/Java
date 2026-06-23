package Encapsulation;
public class Enapsulation{
    public static void main(String[] args){
        BankAccount ba = new BankAccount();
        ba.deposit(500);
        ba.withdraw(300);
        System.out.println(ba.getBalance());
        
    }
}

class BankAccount{
    private double balance;
    public void deposit(int amount){
        balance+=amount;
    }
    public void withdraw(int amount){
        //can add check conditions, eg: balance >= amount
        balance-=amount;
    }
    public double getBalance(){
        return balance;
    }
}

class Student{
    private String name;
    // private int rollNumber;
    // private int age;
    // private String college;

    Student(String name, int rollNumber, int age, String college){
        this.name = name;
        // this.rollNumber = rollNumber;
        // this.age = age;
        // this.college = college;
    }

    //getters and setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name; 
    }
}
