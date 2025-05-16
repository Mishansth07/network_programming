package UDP;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPChannelReceive{
    public static void main(String[] args) {
        try {
            DatagramChannel receiveChannel = DatagramChannel.open();
            SocketAddress receiverAddress = new InetSocketAddress(3012);
            receiveChannel.bind(receiverAddress);
            ByteBuffer buffer = ByteBuffer.allocate(100);
            while (true) {
                receiveChannel.receive(buffer);
                buffer.flip();
                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);
                String message = new String(data);
                System.out.println("Message from client: " + message);
                buffer.clear();
            }
            
        } 
        catch (IOException ex) {
           System.out.println("IOError: " + ex.getMessage());
        }
    }

}