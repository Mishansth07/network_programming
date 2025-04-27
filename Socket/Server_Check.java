package Socket;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException; 

public class Server_Check {
    public static void main(String[] args) {
        for(int i = 75; i<185; i++){
            try{
                Socket soc = new Socket("192.168.1.175",i);
                System.out.println("Server found at port: "+i);

            }
            
            catch(UnknownHostException ex){
                System.out.println("Unable to resolve the host");
            }
            catch(IOException ex) {
                System.out.println("No server defined at the port no:" +i);
            }
        }
    }
    
}
