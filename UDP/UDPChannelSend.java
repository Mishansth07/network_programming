package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPChannelSend {
    public static void main (String [] args){
        try {
            DatagramChannel sendChannel = DatagramChannel.open();
            SocketAddress senderAddress = new InetSocketAddress(5556);
            sendChannel.bind(senderAddress);
    
            BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in)); 
   
            String toSend = "";

            while (true) {
                System.out.println("Enter message to be send.");
                toSend = sysReader.readLine();
               
                byte[] message = toSend.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(message);
                SocketAddress receiverAddress = new InetSocketAddress("localhost", 3012);
                sendChannel.send(buffer, receiverAddress);
                System.out.println("Message to Server: " + toSend + " Sent");
                buffer.clear();    
            }
            }
    
        catch (IOException ex) {
            System.out.println("IOError: " + ex.getMessage());
        }
    }
    
}
