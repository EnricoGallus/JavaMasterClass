public class PrimeNumber {
    public static void main(String[] args) {
        int primeNumbersFound = 0;
        for (int i = 12; i < 99; i++) {
            boolean isPrime = isPrime(i);
            if (isPrime) {
                primeNumbersFound++;
                System.out.println("Number " + i + " is a prime number");
                if (primeNumbersFound == 3) {
                    System.out.println("Exiting for loop");
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= (long) Math.sqrt(n); i++) {
            System.out.println("Looping " + i);
            if (n % 2 == 0) {
                return false;
            }
        }

        return true;
    }
}
