package day0609.bank;

public class Account {
    private int ID;
    private double banlance;
    private double annualInterestRate;

    public Account(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return ID;
    }

    public double getBanlance() {
        return banlance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBanlance(double banlance) {
        this.banlance = banlance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void withdraw(double money) {
        if (money >= banlance) {
            System.out.println("余额不足，取款失败！");
        } else if (money < 0){
            System.out.println("输入值错误！");
        } else {
            banlance -= money;
            System.out.println("成功存入：" + money);
        }
    }


    public void deposit(double money){
        if(money < 0){
            System.out.println("输入值错误！");
        }else{
            banlance += money;
            System.out.println("成功取出：" + money);
        }
    }



}
