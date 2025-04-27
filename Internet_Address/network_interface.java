import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.InetAddress;;

public class network_interface {
    public static void main(String[] args) {
        try{
            InetAddress ia = InetAddress.getLocalHost();

            NetworkInterface wni = NetworkInterface.getByName("wlan0");
            NetworkInterface eni = NetworkInterface.getByName("eth0");

            NetworkInterface ina = NetworkInterface.getByInetAddress(ia);

            System.out.println(wni);
            System.out.println(eni);
            System.out.println(ina);


        }

        catch(SocketException ex){
            System.out.println("SocketException Occured");
        }
        catch(UnknownHostException ex){
            System.out.println("UnknownHostException occured");
        }

    }
}
