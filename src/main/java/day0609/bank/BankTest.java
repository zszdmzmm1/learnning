package day0609.bank;

public class BankTest {
    public static void main(String[] args) {
        Customer user = new Customer("小", "富");
        Account userAccount = user.setAccount(0.0123);
        userAccount.setID(1000);
        userAccount.setBanlance(2000);
        userAccount.deposit(100);
        userAccount.withdraw(960);
        userAccount.withdraw(2000);

        System.out.println(user.showAccount());
    }
}
