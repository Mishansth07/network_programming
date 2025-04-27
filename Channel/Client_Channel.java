import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client_Channel {
    public static void main(String[] args) {
        try{
            SocketChannel clientChannel = SocketChannel.open();
            clientChannel.configureBlocking(false);
            clientChannel.connect(new InetSocketAddress("localhost", 3001));
            while (!clientChannel.finishConnect()) {}
            String toServer = "Good Morning";
            ByteBuffer buffer = ByteBuffer.wrap(toServer.getBytes());
            clientChannel.write(buffer);
            System.out.println("Message sent to server: " +toServer);
            clientChannel.close();
        }

        catch(IOException ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }
    
}
