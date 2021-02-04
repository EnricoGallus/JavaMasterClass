public class FirstLastDigitSum {
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(11));
        System.out.println(sumFirstAndLastDigit(5));
        System.out.println(sumFirstAndLastDigit(78881));
    }

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        if (number / 10 == 0) {
            return 2 * number;
        }

        int sum = 0, count = 0;

        do {
            int digit = number % 10;
            number /= 10;
            count++;
            if (count == 1 || number == 0) {
                sum += digit;
            }
        } while (number != 0);

        return sum;
    }
}
