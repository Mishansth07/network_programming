package Multi_Thread_Chat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Multi_Thread_Client {
    public static void main(String[] args) {
        try{ 
            Socket soc = new Socket("localhost", 3005);
            InputStream inStream = soc.getInputStream();
            OutputStream outStream = soc.getOutputStream();

            BufferedReader bfReader = new BufferedReader(new InputStreamReader(inStream));
            BufferedWriter bfWriter = new BufferedWriter(new OutputStreamWriter(outStream));

            String toServer = "";
            String fromServer ="";

            BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                
            
            toServer = sysReader.readLine();
            bfWriter.write(toServer+"\r\n");
            bfWriter.flush();

            fromServer = bfReader.readLine();
            System.out.println("Message from server "+fromServer);
        }
        }

        catch(IOException ex){
            System.out.println("IO Error: "+ex.getMessage());
        }
    }
    
}

    
