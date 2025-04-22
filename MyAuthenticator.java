import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

public class MyAuthenticator extends Authenticator {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("admin", "admin".toCharArray());
    }

    public static void main(String[] args) {
        try {
            // Set custom Authenticator
            Authenticator.setDefault(new MyAuthenticator());

            // Example protected URL (Replace with a real one)
            URL url = new URL("https://httpbin.org/basic-auth/admin/admin"); // Dummy API for testing authentication

            // Open HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else {
                System.out.println("Authentication failed or access denied.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
