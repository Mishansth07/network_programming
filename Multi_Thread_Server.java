import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Multi_Thread_Server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(3005);
            while(true){
                Socket clienSocket = server.accept();
                Multi_Thread threadedServer = new Multi_Thread(clienSocket);
                new Thread(threadedServer).start();
            }
        }
        catch(IOException ex){
            System.out.println("IOError: "+ex.getMessage());
        }
    }
    
}
