import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.net.URL;
import java.net.URLDecoder;

public class URL_Encoder {
    public static void main (String [] args) {
        try {
            // URL Encoding
            String u = URLEncoder.encode("50$ Bank/s'Transfer","UTF-8" );
            URL ur = new URL("http://www.abcbank.com/payment/Query="+u);
            System.out.println(ur);

            // Url decoding
            String dec = ur.toString();
            System.out.println(URLDecoder.decode(dec, "UTF-8"));

        }

        catch (MalformedURLException e) {
            System.out.println("MalformedURLException Occured");
        }

        catch(UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException Occured");
        }
    }
}