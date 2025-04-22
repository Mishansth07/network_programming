import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Multi_Thread implements Runnable{
    public Socket client;
    public Multi_Thread(Socket clienSocket){
        this.client = clienSocket;
    }

    @Override
    public void run(){
        try{
            BufferedWriter bfWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader bfReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));

            String toClient = "";
            String fromClient = "";

            while (!fromClient.equalsIgnoreCase("quite")) {
                fromClient = bfReader.readLine();
                System.out.println("Message from client: " + fromClient);

                toClient = sysReader.readLine();
                
                bfWriter.write(toClient+ "\r\n");
               
                bfWriter.flush();
               
                
            }

        }
        catch(IOException ex){
            System.out.println("IOError5:" +ex.getMessage());
        }
    }
    
}
