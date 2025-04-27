import java.net.InetAddress;
import java.net.UnknownHostException;

public class ResolveIP {
    public static void main(String[] args) {
        try {
            // Get all IP addresses associated with www.apple.com
            InetAddress[] addresses = InetAddress.getAllByName("www.apple.com");

            // Display each IP address
            System.out.println("IP Addresses for www.apple.com:");
            for (InetAddress address : addresses) {
                System.out.println(address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("Could not resolve www.apple.com");
        }
    }
}
