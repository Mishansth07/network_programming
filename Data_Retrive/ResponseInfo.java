package Data_Retrive;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.Reader;

public class ResponseInfo {
    public static void main(String[] args) {
        try {
            URL ur = new URL("https://www.bhaktapur.com/");
            URLConnection uc = ur.openConnection();
            HttpURLConnection huc = (HttpURLConnection) uc;

            int code = huc.getResponseCode();
            String message = huc.getResponseMessage();

            System.out.println("THE RESPONSE");
            System.out.println(code + " " + message);

            System.out.println("THE HEADER");
            for (int i = 1; ; i++) {
                String field = huc.getHeaderField(i);
                String key = huc.getHeaderFieldKey(i);
                if (field == null && key == null) break;
                if (key != null) {
                    System.out.println(key + ": " + field);
                }
            }

            InputStream is = new BufferedInputStream(huc.getInputStream());
            Reader rd = new InputStreamReader(is);
            int a;
 
            System.out.println("\nTHE BODY");
            while ((a = rd.read()) != -1) {
                System.out.print((char) a);
            }

            huc.disconnect();
        } catch (MalformedURLException me) {
            System.out.println("URL syntax error");
        } catch (IOException ie) {
            System.out.println("I/O error occurred");
        }
    }
}
