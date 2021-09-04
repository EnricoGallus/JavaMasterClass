import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        try {
           Pipe pipe = Pipe.open();

           Runnable writer = new Runnable() {
               @Override
               public void run() {
                   try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);
                        for (int i=0; i<10; i++) {
                            String currentTime = "The time is: " + System.currentTimeMillis();
                            buffer.put(currentTime.getBytes(StandardCharsets.UTF_8));
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }

                            buffer.flip();

                            Thread.sleep(100);
                        }
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           };

           Runnable reader = new Runnable() {
               @Override
               public void run() {
                   try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);
                       for (int i=0; i<10; i++) {
                           int bytesToRead = sourceChannel.read(buffer);
                           byte[] timeString = new byte[bytesToRead];
                           buffer.flip();
                           buffer.get(timeString);
                           System.out.println("Reader Thread: " + new String(timeString));
                           buffer.flip();
                           Thread.sleep(100);
                       }

                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           };

           new Thread(writer).start();
           new Thread(reader).start();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileOutputStream binFile = new FileOutputStream("Section14_5NIO_ReadWrite/data2.dat");
             FileChannel binChannel = binFile.getChannel()) {

            byte[] outputBytes = "Hello World!".getBytes(StandardCharsets.UTF_8);
            long int1Pos = outputBytes.length;
            long int2Pos = int1Pos + Integer.BYTES;
            byte[] outputBytes2 = "Nice to meet you".getBytes(StandardCharsets.UTF_8);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            ByteBuffer buffer = ByteBuffer.allocate(100)
                .put(outputBytes)
                .putInt(245)
                .putInt(-98765)
                .put(outputBytes2)
                .putInt(1000)
                .flip();
//            byte[] outputBytes = "Hello World!".getBytes(StandardCharsets.UTF_8);
//            buffer.put(outputBytes);
//            buffer.putInt(245);
//            buffer.putInt(-98765);
//            byte[] outputBytes2 = "Nice to meet you".getBytes(StandardCharsets.UTF_8);
//            buffer.put(outputBytes2);
//            buffer.putInt(1000);
//            buffer.flip();
            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("Section14_5NIO_ReadWrite/data2.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = " + readBuffer.getInt());

            RandomAccessFile copyFile = new RandomAccessFile("Section14_5NIO_ReadWrite/datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);
            //long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transferred = " + numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();

            /*ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("input string = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("input string 2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());*/

//            //ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//            buffer.flip();
//
//            int numBytes = binChannel.write(buffer);
//            System.out.println("numBytes written: " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written: " + numBytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written: " + numBytes);
//
//            RandomAccessFile ra = new RandomAccessFile("Section14_5NIO_ReadWrite/data.dat", "rwd");
//            FileChannel readChannel = ra.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//            long numBytesRead = readChannel.read(buffer);
//            if (buffer.hasArray()) {
//                System.out.println("output bytes = " + new String(buffer.array()));
//                //System.out.println("byte buffer = " + new String(outputBytes));
//            }
//
//            // absolute read
//            intBuffer.flip();
//            numBytesRead = readChannel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytesRead = readChannel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt(0));
//            System.out.println(intBuffer.getInt());
//
//                    /* relative read
//                    intBuffer.flip();
//                    numBytesRead = readChannel.read(intBuffer);
//                    intBuffer.flip();
//                    System.out.println(intBuffer.getInt());
//                    intBuffer.flip();
//                    numBytesRead = readChannel.read(intBuffer);
//                    intBuffer.flip();
//                    System.out.println(intBuffer.getInt());*/
//            readChannel.close();
//            ra.close();



            /*RandomAccessFile ra = new RandomAccessFile("Section14_5NIO_ReadWrite/data.dat", "rwd");
            byte[] b = new byte[outputBytes.length];
            ra.read(b);
            System.out.println(new String(b));

            long int1 = ra.readInt();
            long int2 = ra.readInt();
            System.out.println(int1);
            System.out.println(int2);*/


            /*FileInputStream file = new FileInputStream("data.txt");
            FileChannel channel = file.getChannel();*/
            /*Path dataPath = FileSystems.getDefault().getPath("Section14_5NIO_ReadWrite/data.txt");
            Files.write(dataPath, "\nLine 5".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(dataPath);
            for (String line : lines) {
                System.out.println(line);
            }*/
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
