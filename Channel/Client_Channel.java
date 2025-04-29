import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client_Channel {
    public static void main(String[] args) {
        try {
            InetSocketAddress sa = new InetSocketAddress("localhost", 3001);
            SocketChannel client = SocketChannel.open(sa);
            client.configureBlocking(true); // Make sure it blocks on read/write
            BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));
            
            ByteBuffer readBuffer = ByteBuffer.allocate(1024); // Buffer for reading data
            
            while (true) {
                System.out.print("Enter message: ");
                String text = sysReader.readLine();
                if (text == null || text.equalsIgnoreCase("exit")) {
                    System.out.println("Closing connection...");
                    break;
                }

                // Send data to server
                byte[] message = text.getBytes();
                ByteBuffer writeBuffer = ByteBuffer.wrap(message);
                client.write(writeBuffer);
                System.out.println("Sent: " + text + " to " + sa);

                // Read response from server
                readBuffer.clear();
                int bytesRead = client.read(readBuffer);
                if (bytesRead > 0) {
                    readBuffer.flip();
                    byte[] responseData = new byte[bytesRead];
                    readBuffer.get(responseData);
                    String response = new String(responseData);
                    System.out.println("Server Response: " + response);
                }
            }

            client.close();
        } catch (IOException ex) {
            System.out.println("Error Message: " + ex.getMessage());
        }
    }
}
