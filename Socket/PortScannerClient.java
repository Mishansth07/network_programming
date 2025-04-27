package Socket;
import java.io.IOException;
import java.net.Socket;

public class PortScannerClient {
    public static void main(String[] args) {
        String host = "192.168.254.27";

        for (int port = 135; port <= 140; port++) {
            try (Socket socket = new Socket(host, port)) {
                System.out.println("Port " + port + " is open on " + host);
            } catch (IOException e) {
                System.out.println("Port " + port + " is closed on " + host);
            }
        }
    }
}
