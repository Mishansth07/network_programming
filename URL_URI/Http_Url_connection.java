package URL_URI;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class Http_Url_connection {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.google.com");
            URLConnection uc = url.openConnection();
            HttpURLConnection huc = (HttpURLConnection)uc;
            int code = huc.getResponseCode();
            String message = huc.getResponseMessage();
            System.out.println("The Response");
            System.out.println(code + "" + message);

            for(int i=0; ;i++){
                String headerName = huc.getHeaderField(i);
                String headerValue = huc.getHeaderField(i);
                if(headerName == null && headerValue==null){
                    break;
                }
                else{
                    System.out.println("The header");
                    System.out.println("header Name is: " +headerName);
                    System.out.println("header Value is: " +headerValue);
                }
            }

            InputStream ins = url.openStream();
            int line;
            while((line = ins.read())!=-1){
                System.out.print(line);
            }
        }

        catch(MalformedURLException ex){
            System.out.println("URL not found");
        }
        catch(IOException ex){
            System.out.println("IOException found");
        }


    }
    
}
