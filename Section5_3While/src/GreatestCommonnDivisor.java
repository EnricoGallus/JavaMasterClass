public class GreatestCommonnDivisor {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 15));
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }

        int commonDivisor = 1;
        int smallerValue = first > second ? second : first;
        for (int i = smallerValue; i > 1; i--) {
            if (first % i == 0 && second % i == 0) {
                commonDivisor = i;
                break;
            }
        }

        return commonDivisor;
    }
}
