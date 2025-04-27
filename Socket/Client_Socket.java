package Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client_Socket {
    public static void main(String[] args) {
        try{
            Socket connection = new Socket("localhost", 3005);
            InputStream inStream = connection.getInputStream();
            int a;
            while ((a= inStream.read())!=-1) {
                System.out.print ((char)a);
                
            }
            }
            catch(IOException ex){
                System.out.println("Io error");
            }
            
        }
    }
    

