import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class interface_IP {
    	public static void main(String args[]){
		try{
				NetworkInterface nif1 = NetworkInterface.getByName("eth4");
				System.out.println(nif1);
				Enumeration add = nif1.getInetAddresses();
				while(add.hasMoreElements()){
					System.out.println(add.nextElement());
				}
						}
		catch(SocketException se){System.out.println("unable to resolve");
		}
	}

    
}
