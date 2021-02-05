public class DiagonalStar {
    public static void main(String[] args) {
        printSquareStar(8);
    }

    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for (int x = number; x > 0; x--) {
                for (int y = number; y > 0; y--) {
                    if (x == 1 || x == number
                            || y == 1 || y == number
                            || x == y
                            || y == (number - x + 1)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }

                System.out.println("");
            }
        }
    }
}
