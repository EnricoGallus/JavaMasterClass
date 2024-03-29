public class Main {
    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable()) {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class's implement of MyRunnable");
                try {
                    anotherThread.join();
                    System.out.println(ThreadColor.ANSI_RED + "AnotherThread terminated or timed out, so i'm running again");
                } catch (InterruptedException ex) {
                    System.out.println(ThreadColor.ANSI_RED + "I couldn't wait after all. I was interrupted.");
                }
            }
        };
        myRunnableThread.start();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");
    }
}