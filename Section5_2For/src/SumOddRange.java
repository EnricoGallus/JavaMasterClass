public class SumOddRange {
    public static void main(String[] args) {
        sumOdd(1, 100);
        sumOdd(100, 100);
    }

    public static boolean isOdd(int number) {
        if (number <= 0) {
            return false;
        }

        return number % 2 != 0;
    }

    public static int sumOdd(int start, int end) {
        if (start > end || start <= 0) {
            return -1;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                sum += i;
            }
        }

        System.out.println(sum);
        return sum;
    }
}
