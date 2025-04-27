import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class FindMacAdd {
    public static void main(String[] args) {
        try {
            InetAddress ina = InetAddress.getLocalHost();
            String ip_address= ina.getHostAddress();
			System.out.println("The Host IP address: "+ip_address);

            NetworkInterface ni = NetworkInterface.getByInetAddress(ina);
            byte[] mac = ni.getHardwareAddress();
            StringBuilder sb = new StringBuilder() ;
            for(byte m:mac){
                sb.append(String.format("%02X",m));
            }  
            System.out.println("The Host MAC address: " +sb);         
        } 
        
        catch (SocketException e) {
            System.out.println("SocketException Occured");
            
        }

        catch(UnknownHostException e) {
            System.out.println("UnknownHostException Occured");
        }
    }
    
}
