import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class socket_example {
    public static void main(String [] args){
        try{
        Socket soc = new Socket("dict.org", 2628);
        soc.setSoTimeout(20000);
        OutputStream outStream = soc.getOutputStream();
        BufferedWriter bfWriter = new BufferedWriter(new OutputStreamWriter(outStream));
        bfWriter.write("DEFINE gcide india\r\n");
        bfWriter.flush();

        InputStream inStream = soc.getInputStream();
        BufferedReader bfReader = new BufferedReader(new InputStreamReader(inStream));
        for(String line = bfReader.readLine(); line!=null; line=bfReader.readLine()){
            if(line.startsWith("250")){
                break;
            }
            else{
                System.out.println(line);
            }
        }
        bfWriter.write("quit\r\n");
        bfWriter.flush();
        }

        catch(IOException ex){
            System.out.println("IO_Error:" + ex.getMessage());
        }
    }
    
}
