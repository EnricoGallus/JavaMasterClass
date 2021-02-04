public class EvenDigitSum {
    public static void main(String[] args) {

    }

    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }

        int evenSum = 0;
        while (true) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }

            number /= 10;
            if (number == 0) {
                break;
            }
        }

        return evenSum;
    }
}
