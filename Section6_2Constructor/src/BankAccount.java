public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(String customerName, String email, String phoneNumber) {
        this("99999", 100.5, customerName, email, phoneNumber);
    }

    public BankAccount() {
        this("56789", 2.50, "default name", "default email", "default phone");
        System.out.println("Empty constructor called");
    }

    public BankAccount(String number, double balance, String name, String email, String phone) {
        this.accountNumber = number;
        this.balance = balance;
        this.customerName = name;
        this.email = email;
        this.phoneNumber = phone;
        System.out.println("Constructor with parameters called");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(amount + " have been deposit. balance = " + this.balance);
    }

    public void withdrawal(double amount) {
        if (balance - amount < 0) {
            System.out.println("You cannnot withdrawal " + amount + ". You have insufficient balance: " + balance);
        } else {
            balance -= amount;
            System.out.println(amount + " have been withdraw. balance = " + this.balance);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
