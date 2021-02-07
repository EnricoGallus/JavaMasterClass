package printer;

public class Main {
    public static void main(String[] args) {
        Printer duplex = new Printer(50, false);
        System.out.println("intitial page count = " + duplex.getPagesPrinted());
        int pagesPrinted = duplex.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + " new total pages count is " + duplex.getPagesPrinted());
        pagesPrinted = duplex.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted + " new total pages count is " + duplex.getPagesPrinted());
    }
}
