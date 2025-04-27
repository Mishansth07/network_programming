package URL_URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;;


public class guess_content_type {
    public static void main(String [] args) {
        try{
            URL url = new URL("Https://www.java.com/home/index/index.html");
            URLConnection uc = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) uc;

            System.out.println("Response" + http.getResponseCode());
            System.out.println("Response message" + http.getResponseMessage());

            String type = URLConnection.guessContentTypeFromName(url.getPath());
            System.out.println(type);
        }

        catch(MalformedURLException e){
            System.out.println("MalformedURLException Occured");
        }

        catch(IOException e) {
            System.out.println("IOEXCEPTION Occured");
        }

        

    }
    
}
