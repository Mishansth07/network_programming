import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server_Socket {
    public static void main(String [] args){
        try{
            ServerSocket server = new ServerSocket(3005);
            while (true) {
                Socket connection = server.accept();
                OutputStream outStream = connection.getOutputStream();
                BufferedWriter bfWriter = new BufferedWriter(new OutputStreamWriter(outStream));
                Date now = new Date();
                String current = now.toString();
                bfWriter.write(current+"\r\n");
                bfWriter.flush();
                
            }
        }
        catch(IOException ex){
            System.out.println("IO Error: "+ex.getMessage());
        }
    }
    
}
