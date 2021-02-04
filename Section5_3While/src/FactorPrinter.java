public class FactorPrinter {
    public static void main(String[] args) {
        printFactors(32);
    }

    public static void printFactors(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        } else {
            for (int i = number; i > 0; i--) {
                double factor = number / (double)i;
                boolean hasNoRest = (factor - (number / i)) / 10 == 0;
                if (hasNoRest) {
                    System.out.println((int)factor);
                }
            }
        }
    }
}
