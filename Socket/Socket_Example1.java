package Socket;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Socket_Example1 {
    public static void main(String[] args){
		try{
			String hostname = "time.nist.gov";
			Socket s = new Socket(hostname,13);
			s.setSoTimeout(10000);			
			StringBuilder sb = new StringBuilder();
			InputStream is = s.getInputStream();
			int a;
			while((a=is.read())!=-1){
                sb.append((char)a);
            }
			System.out.println(sb);			
		}
		catch(IOException ie){System.out.println("I/O Error");}
	}

    
}
