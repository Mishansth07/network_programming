import java.io.IOException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSL_Socket {
    public static void main(String [] args){
        try{
            SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket)factory.createSocket("www.usps.com", 443);
            System.out.println("Successfully connected to: "+socket);

        }
        catch(IOException ex){
            System.out.println("IOError " + ex.getMessage());
        }
    } 
    
}
