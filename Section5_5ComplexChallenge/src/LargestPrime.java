public class LargestPrime {
    public static void main(String[] args) {
        //System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(45));
    }

    // i would have never come up with this solution. that's brilliant
    // and after grilling my brain i used the solution from the forum
    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                number /= i;
                i--;
            }
        }

        return number;
    }
}
