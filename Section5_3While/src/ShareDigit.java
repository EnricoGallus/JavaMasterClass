public class ShareDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 13));
    }

    public static boolean hasSharedDigit(int a, int b) {
        if (a < 10 || a > 99 || b < 10 || b > 99) {
            return false;
        }

        for (int i = a; i != 0; i /= 10) {
            int digitOfA = a % 10;
            int copyOfB = b;
            for (int j = copyOfB; j != 0; j /= 10) {
                int digitOfB = copyOfB % 10;
                if (digitOfA == digitOfB) {
                    return true;
                }

                copyOfB /= 10;
            }

            a /= 10;
        }

        return false;
    }
}
