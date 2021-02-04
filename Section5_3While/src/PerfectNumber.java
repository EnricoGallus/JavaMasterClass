public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(28));
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int divisorSum = 0;
        int excludedPerfect = number - 1;
        for (int i = excludedPerfect; i > 0; i--) {
            if (number % i == 0) {
                divisorSum += i;
            }
        }

        return divisorSum == number;
    }
}
