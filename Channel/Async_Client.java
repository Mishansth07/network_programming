import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class Async_Client {
    public static void main(String[] args) {
        try {
            
            AsynchronousSocketChannel clientChannel = AsynchronousSocketChannel.open();
            
            
                Future<Void> result = clientChannel.connect(new InetSocketAddress("localhost", 3001));
                result.get();
                String message = "Hello from client";
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                Future<Integer> writeResult = clientChannel.write(buffer);
                writeResult.get();
                System.out.println("Message sent to server: " + message);
                clientChannel.close();
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
