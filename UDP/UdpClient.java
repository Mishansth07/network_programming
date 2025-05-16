package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
public static void main(String[] args) {
    try {
        while (true) {
            BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = sysReader.readLine();
            byte[] message = msg.getBytes();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            DatagramPacket packet = new DatagramPacket(message, message.length,serverAddress, 5556);
            DatagramSocket udpSocket = new DatagramSocket();
            udpSocket.send(packet);

            DatagramPacket packet2 = new DatagramPacket(new byte[100], 100);
            udpSocket.receive(packet2);
            String message1 = new String(packet2.getData(),
            0,packet2.getLength());
            System.out.println("Message from Server: "+message1);
            
        }
        
    } catch (IOException ex) {
        System.out.println("IOError: "+ex.getMessage());
    }
}
    
}
