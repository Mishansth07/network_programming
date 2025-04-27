package Socket;
import java.io.IOException;
import java.net.ServerSocket;

public class Port_Scan_Server {
    public static void main(String[] args) {
        for(int i =130; i<=136;i++){
            try{
                ServerSocket server =  new ServerSocket(i);
                System.out.println("Server created at "+i);
            }
            catch(IOException ex){
                System.out.println("Unable to create server socket at "+i+" due to: "+ex.getMessage());
            }
        }
    }
    
}
