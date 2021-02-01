public class Challenge {
    public static void main(String[] args) {
        for (int i = 2; i <= 8; i++) {
            System.out.println("10000 at " + i + "% = " + String.format("%.2f", Main.calculateInterest(10000d, i)));
        }

        System.out.println("******************");

        for (int i = 8; i >= 2; i--) {
            System.out.println("10000 at " + i + "% = " + String.format("%.2f", Main.calculateInterest(10000d, i)));
        }
    }
}
