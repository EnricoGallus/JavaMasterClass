public class DecimalComparator {

    public static void main(String[] args) {
        areEqualByThreeDecimalPlaces(54.123, 3.123);
    }

    /**
     * My implementation, which will compare the first three decimal points including the sign
     * a) multiply a and b each by 1000 and cast to int ex.: 44.1231231 -> 44_123
     * b) cast a and b each into int and multiply by 1000 44.1231231 -> 44000
     * c) deduct result from a) from b) for each
     * @param a first number
     * @param b second number
     * @return true if the first three decimal places are equal including sign, otherwise false
     */
    /*public static boolean areEqualByThreeDecimalPlaces(double a, double b) {
        int intOfA = (int)a;
        int zeroedA = (int)(a * 1000) - (intOfA * 1000);
        int intOfB = (int)b;
        int zeroedB = (int)(b * 1000) - (intOfB * 1000);

        return zeroedA == zeroedB;
    }*/

    public static boolean areEqualByThreeDecimalPlaces(double a, double b) {
        int aTruncatedTo3Decimal = (int)(a * 1000);
        int bTruncatedTo3Decimal = (int)(b * 1000);

        return aTruncatedTo3Decimal == bTruncatedTo3Decimal;
    }
}
