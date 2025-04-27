package Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Chat_Server_program {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(140);
            Socket clientSocket = server.accept();
            InputStream inStream = clientSocket.getInputStream();
            OutputStream outStream = clientSocket.getOutputStream();

            BufferedReader bfReader = new BufferedReader(new InputStreamReader(inStream));
            BufferedWriter bfWriter = new BufferedWriter(new OutputStreamWriter(outStream));

            String fromClient = "";
            String toClient = "";

            BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));

            while (!fromClient.equalsIgnoreCase("Stop")) {
                fromClient = bfReader.readLine();
                System.out.println("Message from client: "+ fromClient);
                toClient = sysReader.readLine();
                bfWriter.write(toClient+"\r\n");
                bfWriter.flush();
                
            }
        }

        catch(IOException ex){
            System.out.println("IO Error:" +ex.getMessage());
        }
    }
    
}
