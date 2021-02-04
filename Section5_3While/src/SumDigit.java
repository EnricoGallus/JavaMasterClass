public class SumDigit {
    public static void main(String[] args) {
        System.out.println("125 % 10 = " + 125 % 10);

        System.out.println(sumDigits(125));
        System.out.println(sumDigits(32123));

    }

    public static int sumDigits(int number) {
        if (number < 10) {
            return -1;
        }

        int sum = 0;
        while (true) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
            if (number == 0) {
                break;
            }
        }

        return sum;
    }
}
