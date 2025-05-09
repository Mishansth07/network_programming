package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class DatagramServer {
    public static void main(String[] args) {
        try {
            DatagramSocket udpSocket = new DatagramSocket(5556);
            while (true) {
                DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                udpSocket.receive(request);
                String daytime = new Date().toString();
                byte[] data = daytime.getBytes();
                InetAddress host = request.getAddress();
                int port = request.getPort();
                DatagramPacket response = new DatagramPacket(data,data.length,host,port);
                udpSocket.send(response);
                
            }
            
        } catch (IOException e) {
            System.out.println("IOError:" + e.getMessage());
            
        }
    }
    
}
