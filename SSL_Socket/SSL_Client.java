package SSL_Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSL_Client {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "Keys/myTrustStore.jts");
        // System.setProperty("javax.net.ssl.trustStore", "Keys/myTrustStore.jts");
        System.setProperty("javax.net.ssl.trustStorePassword", "123456");

        try{
            SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            // SSLSocket client = (SSLSocket)factory.createSocket("192.168.1.168", 2356);
            SSLSocket client = (SSLSocket)factory.createSocket("localhost", 2356);
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            String fromServer = "";
            String toServer = "";

            BufferedReader bfReader = new BufferedReader(new InputStreamReader(inStream));
            BufferedWriter bfWriter = new BufferedWriter(new OutputStreamWriter(outStream));
            BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(client.getSession());
            while (!fromServer.equals("quit")) {
                toServer = sysReader.readLine();
                bfWriter.write(toServer+"\r\n");
                bfWriter.flush();

                fromServer = bfReader.readLine();
                System.out.println("message from server: " + fromServer);
            }
        }

        catch(Exception ex){
            System.out.println("Exception Occured: "+ex.getMessage());
        }
    }
    
}
