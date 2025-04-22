import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SSL_Server {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore", "C:/Users/Acer/jnp4e.keysjnp4e.keys");
        System.setProperty("java.net.ssl.keyStorePassword", "123456");

        try{
            SSLContext context = SSLContext.getInstance("TLS");
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SUNX509");
            KeyStore ks = KeyStore.getInstance("JKS");
            char[] password = "123456".toCharArray();
            ks.load(new FileInputStream("C:/Users/Acer/jnp4e.keysjnp4e.keys"), password);
            kmf.init(ks, password);
            context.init(kmf.getKeyManagers(), null, null);
            SSLServerSocketFactory factory = context.getServerSocketFactory();
            SSLServerSocket server = (SSLServerSocket)factory.createServerSocket(2356);

            while (true) {
                SSLSocket client = (SSLSocket)server.accept();
                InputStream inStream = client.getInputStream();
                OutputStream outStream = client.getOutputStream();

                String fromClient = "";
                String toClient = "";

                BufferedReader bfReader = new BufferedReader(new InputStreamReader(inStream));
                BufferedWriter bfWriter = new BufferedWriter(new OutputStreamWriter(outStream));
                BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));

                System.out.println(client);

                while (!fromClient.equals("quit")) {
                    fromClient = bfReader.readLine();
                    System.out.println("message from client: " + fromClient);
                    toClient = sysReader.readLine();
                    bfWriter.write(toClient + "\r\n");
                    bfWriter.flush();
                    
                }

                
            }


        }

        catch(Exception ex){
            System.out.println("Error occured: " + ex.getMessage());
        }
    }
    
}
