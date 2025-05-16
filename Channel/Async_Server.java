import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java. nio.channels.AsynchronousSocketChannel;
public class Async_Server {
    public static void main (String [] args){
        try {
            AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
            server.bind(new InetSocketAddress("localhost", 5556));

            while (true) {
                Future<AsynchronousSocketChannel> acceptConnection = server.accept();
                AsynchronousSocketChannel client = acceptConnection.get(100, TimeUnit.SECONDS);

                if ((client!=null) && (client.isOpen())) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    Future<Integer> readVal = client.read(buffer);
                    readVal.get();
                    buffer.flip();
                    byte[] fromClient = new byte[buffer.remaining()];
                    buffer.get(fromClient);
                    System.out.println("message from client: " + new String(fromClient));
                    client.close();
                }

                
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
