package day0609.bank;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account setAccount(double anaualInterestRate) {
        if (this.account == null) {
            this.account = new Account(anaualInterestRate);
        }
        return this.account;
    }


    public String showAccount() {
        return "Customer [" + firstName + lastName
                + "] 有一个账户：id = " + account.getId()
                + ", annualInterestRate="
                + (account.getAnnualInterestRate() * 100.0)
                + "%, banlance=" + account.getBanlance();
    }
}
