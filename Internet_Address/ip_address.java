import java.net.InetAddress;
import java.net.UnknownHostException;

public class ip_address {
    public static void main(String [] args) {
        try{
            InetAddress iad = InetAddress.getLocalHost();

            // args[] allows to pass argument as array
            // InetAddress iad = InetAddress.getByName(args[0]);

            byte[] ipa = iad.getAddress();

            if(ipa.length ==4){
                System.out.println("Host has IPV4 address");
            }
            else if(ipa.length == 16){
                System.out.println("Host has IPV6 address");
                
            }
            else{
                System.out.println("Invalid IP address");
            }
        }
        catch(UnknownHostException ex){
            System.out.println("Unable to resolve");
        }
    }

}
