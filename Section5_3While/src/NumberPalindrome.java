public class NumberPalindrome {
    public static void main(String[] args) {
        isPalindrome(11212);
    }

    public static boolean isPalindrome(int number) {
        int tester = number;
        int base = 1;
        while (tester != 0) {
            tester /= 10;
            if (tester == 0) {
                break;
            }

            base *= 10;
        }

        int reverse = 0;
        tester = number;
        while (true) {
            int digit = tester % 10;
            reverse += digit * base;
            base /= 10;
            tester /= 10;
            if (tester == 0) {
                break;
            }
        }

        System.out.println("Reverse = " + reverse);
        System.out.println("Number = " + number);

        return reverse == number;
    }
}
