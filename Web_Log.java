import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Web_Log {
    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("Usage: java Web_Log <logfile>");
            return;
        }

        try (FileInputStream fin = new FileInputStream(args[0]);
             Reader in = new InputStreamReader(fin);
             BufferedReader br = new BufferedReader(in)) {

            String entry;
            while ((entry = br.readLine()) != null) {
                int indx = entry.indexOf(' ');
                if (indx == -1) continue; // Skip invalid lines

                String ip = entry.substring(0, indx);
                String remaining = entry.substring(indx);

                try {
                    InetAddress iadd = InetAddress.getByName(ip);
                    System.out.println(iadd.getHostName() + " " + remaining);
                } catch (UnknownHostException e) {
                    System.out.println("Unable to resolve host for IP: " + ip);
                }
            }
        } catch (IOException ex) {
            System.out.println("IOException occurred: " + ex.getMessage());
        }
    }
}
