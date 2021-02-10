public class Main {
    public static void main(String[] args) {
        //int[] myIntArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] myIntArray = new int[10];
        for (int i = 0; i < myIntArray.length; i++) {
            myIntArray[i] = i * 10;
        }

        printArray(myIntArray);

        /*int[] myIntArray = new int[10];
        myIntArray[0] = 45;
        myIntArray[1] = 476;
        myIntArray[5] = 50;*/
        System.out.println(myIntArray[0]);
        System.out.println(myIntArray[6]);
        System.out.println(myIntArray[8]);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ", value is " + array[i]);
        }
    }
}
