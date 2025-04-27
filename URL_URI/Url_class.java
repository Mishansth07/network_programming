package URL_URI;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;

public class Url_class {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.java.com");
            InputStream ins = url.openStream();
            
            int a;
            while ((a = ins.read()) != -1) {  // Fix: Update 'a' in loop
                System.out.print((char) a);  // Fix: Use print instead of println
            }
            
            ins.close();  // Fix: Close InputStream after use
        } 
        catch (MalformedURLException e) {
            System.out.println("MalformedURLException Occurred");
        } 
        catch (IOException e) {
            System.out.println("IOException Occurred");
        }
    }
}
