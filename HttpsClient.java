import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HttpsClient {
    public static void main(String [] args){
        try{
            String host = "www.google.com";
            SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket)factory.createSocket(host, 443);
            String[] supportSuites = socket.getSupportedCipherSuites();
            socket.setEnabledCipherSuites(supportSuites);

            OutputStream outStream = socket.getOutputStream();
            BufferedWriter bfWriter = new BufferedWriter(new OutputStreamWriter(outStream));
            bfWriter.write("GET https://www.google.com/ HTTP/1.1\r\n");
            bfWriter.write("Host:www.google.com\r\n");
            bfWriter.write("\r\n");

            InputStream inStream = socket.getInputStream();
            BufferedReader bfReader = new BufferedReader(new InputStreamReader(inStream));
            String line;
            while((line=bfReader.readLine())!= null){
                System.out.println(line);

            }
        }

        catch(IOException ex){
            System.out.println("IOError: " + ex.getMessage());
        }
    }
    
}
