public class Main {
    public static void main(String[] args) {
        System.out.println("10000 at 2% = " + calculateInterest(10000d, 2d));
        System.out.println("10000 at 3% = " + calculateInterest(10000d, 3d));
        System.out.println("10000 at 4% = " + calculateInterest(10000d, 4d));
        System.out.println("10000 at 5% = " + calculateInterest(10000d, 5d));

        for (int i = 0; i < 5; i++) {
            System.out.println("Loop " + i + " hello!");
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return amount * (interestRate / 100);
    }
}
