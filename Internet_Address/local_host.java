import java.net.InetAddress;
import java.net.UnknownHostException;

public class local_host{
    public static void main(String[] args) {
        try{
            InetAddress local = InetAddress.getLocalHost();
            System.out.println(local);
            System.out.println("Ip address is:" + local.getHostAddress());
            System.out.println("Host name is:" + local.getHostName());
        }
        catch(UnknownHostException uhe){
            System.out.println("UnknownHostException Occured");

        }
    }
}