import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class site_reachable {
    public static void main(String args[]){
		int tout = 60;
		try{
			InetAddress reach = InetAddress.getByName("fohss.tu.edu.np");
			if(reach.isReachable(tout)){
					System.out.println(reach+" is reachable");
                }
else{
		System.out.println("host unreachable");
    }
}
		catch(UnknownHostException ex){
            System.out.println("unable to resolve host");
        }
		catch(IOException exp){
            System.out.println("unreachable");
        }
	}

    
}
