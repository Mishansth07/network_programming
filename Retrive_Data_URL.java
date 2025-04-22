import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
 
public class Retrive_Data_URL {
    public static void main(String[] args) {
        try{
            URL url = new URL ("https://www.java.com");
           
            URLConnection uc = url.openConnection();
            InputStream ins = uc.getInputStream();
            

            int a;
            while ((a = ins.read()) != -1) {
                System.out.print((char)a);
            }
            ins.close();

        }

        catch(MalformedURLException e) {
            System.out.println("MalformedURLException Occured");
        }

        catch(IOException e) {
            System.out.println("IOException Occured");
        }
    }
    
}
