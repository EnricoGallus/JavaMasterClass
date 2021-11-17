import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(() -> {
            System.out.println(ThreadColor.ANSI_WHITE);
            return "This is the callable result";
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {

    private BlockingQueue<String> buffer;
    private String color;

    public MyProducer(BlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {
                System.out.println(color + "Adding... " + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ex) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch (InterruptedException ex){
            System.out.println("Producer was interrupted in putting EOF");
        }
    }
}

class MyConsumer implements Runnable {
    private BlockingQueue<String> buffer;
    String color;

    public MyConsumer(BlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }

                    if (buffer.peek().equals("EOF")) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Consumer was interrupted in putting EOF");
                }
            }
        }
    }
}