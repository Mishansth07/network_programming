import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Socket_Info {
    public static void main(String[] args) {
        try{
            Socket soc = new Socket("time.nist.gov", 13);
            InetAddress remoteAddress = soc.getInetAddress();
            String remoteIp = remoteAddress.getHostAddress();

            InetAddress localAddress = soc.getLocalAddress();
            String localIp = localAddress.getHostAddress();

            System.out.println("The remote port is: "+soc.getPort());
            System.out.println("The remote IP is: "+remoteIp);
            System.out.println("The local port is: "+soc.getLocalPort());
            System.out.println("The local IP is: "+localIp);
        


        }
        catch(UnknownHostException ex){     
            System.out.println("Unable to resolve ");

        }
        catch(IOException ex){
            System.out.println("IOError:" +ex.getMessage());
        }
    }
    
}
