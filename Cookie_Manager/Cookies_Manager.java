import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Cookies_Manager {
    public static void main(String[] args) {
        try {
            CookieManager cm = new CookieManager();
            CookieHandler.setDefault(cm);

            URL url = new URL("https://www.google.com");
            URLConnection uc = url.openConnection();
            uc.getContent();

            CookieStore cs = cm.getCookieStore();
            List<HttpCookie> cookie = cs.getCookies();
            for(HttpCookie hc: cookie) {
                System.out.println(hc);
                System.out.println("Domain: " +hc.getDomain());
                System.out.println("Expires in: " + hc.getMaxAge());
                System.out.println("Path is: " + hc.getPath());
                System.out.println("Cookie name is: " + hc.getName());

            }
        }

        catch(MalformedURLException ex) {
            System.out.println("MalformedURLException Occured");
        }

        catch(IOException ex) {
            System.out.println("IOException Occured");
        }

    }
    
}
