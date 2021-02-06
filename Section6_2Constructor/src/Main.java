public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 0.00, "Tim Ferris", "myemail@tim.com", "(087) 123-4567");
        System.out.println(account.getAccountNumber());
        System.out.println(account.getBalance());
        account.withdrawal(100d);

        account.deposit(50d);
        account.withdrawal(100d);

        account.deposit(50.1d);
        account.withdrawal(100d);

        BankAccount enricoAccount = new BankAccount("Enrico", "enricp@email.com", "1232134");
        System.out.println(enricoAccount.getAccountNumber() + " name " + enricoAccount.getCustomerName());
    }
}
