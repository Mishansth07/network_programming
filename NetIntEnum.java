// get the interfaces of Network

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetIntEnum {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> enif = NetworkInterface.getNetworkInterfaces();
            while (enif.hasMoreElements()) {
                NetworkInterface ni = enif.nextElement();
                System.out.println(ni);
                Enumeration aip = ni.getInetAddresses();
                while (aip.hasMoreElements()) {
                    System.out.println(aip.nextElement());
                    
                }
            }
        } catch (SocketException e) {
            System.out.println("SocketException Occured");
           
        }
    }
}
