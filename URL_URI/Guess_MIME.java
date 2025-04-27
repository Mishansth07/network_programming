package URL_URI;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Guess_MIME {

    public static void main(String[] args) {
        try {
            URL ur = new URL("https://www.google.com");
            InputStream input = ur.openStream();  // Get the stream of the URL
            String mimeType = URLConnection.guessContentTypeFromStream(input);
            System.out.println("Guessed MIME type from stream: " + (mimeType != null ? mimeType : "Unknown"));
            input.close();  // Always close the stream
        } catch (MalformedURLException me) {
            System.out.println("URL syntax error");
        } catch (IOException ie) {
            System.out.println("I/O error: " + ie.getMessage());
        }
    }
}
