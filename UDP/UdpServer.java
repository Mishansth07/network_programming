package UDP;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
    public static void main(String[] args) {
        try{
            DatagramSocket server = new DatagramSocket(5556);
            DatagramPacket packet = new DatagramPacket(new byte[100], 100);
            while (true) {
                server.receive(packet);
                String message = new String (packet.getData(),0,packet.getLength());
                System.out.println("Message from CLient: "+message);
                BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));

                byte[] toClient = sysReader.readLine().getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                DatagramPacket packet2 = new DatagramPacket(toClient, toClient.length, address, port);
                server.send(packet2);
                
            }
        }
        catch(IOException ex){
            System.out.println("IOError: "+ex.getMessage());
        }
    }
}
