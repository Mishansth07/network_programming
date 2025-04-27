package URL_URI;

import java.net.MalformedURLException;
import java.net.URL;


public class URL_Splitting_Methods {
    public static void main(String[] args) {
        try{
            URL url = new URL ("https://admin@www.amazon.com:443/bookfaq/books/index.html?isbn=21506#abc");
            System.out.println("Host Name: "+url.getHost());
            System.out.println("Protocol: "+url.getProtocol());
            System.out.println("Port: "+url.getPort());
            System.out.println("Default Port: "+url.getDefaultPort());
            System.out.println("File: "+url.getFile());
            System.out.println("Path: "+url.getPath());
            System.out.println("Ref: "+url.getRef());
            System.out.println("Ouery: "+url.getQuery());
            System.out.println("UserInfo: "+url.getUserInfo());
            System.out.println("Authority: "+url.getAuthority());
        }

        catch(MalformedURLException e) {
            System.out.println("MalformedURLException Occured");
        }

   

    
}
}
