package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClient {
    public static void main(String[] args) {
        try{
            DatagramSocket udpSocket = new DatagramSocket(0);
            udpSocket.setSoTimeout(10000);
            InetAddress host = InetAddress.getByName("localhost");
            DatagramPacket toSend = new DatagramPacket(new byte[10],10,host,5556);
            byte[] data = new byte[100];
            DatagramPacket toReceive = new DatagramPacket(data, 100);
            udpSocket.send(toSend);
            udpSocket.receive(toReceive);
            String output = new String(toReceive.getData(), 0,toReceive.getLength());
            System.out.println("The response from server is: " + output);
        }
        catch(IOException e){
            System.out.println("IoError: "+ e.getMessage());
        }
    }
    
}
