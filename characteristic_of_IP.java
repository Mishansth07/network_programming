import java.net.InetAddress;
import java.net.UnknownHostException;

public class characteristic_of_IP {
    public static void main(String args[]){
		try{
			InetAddress adr = InetAddress.getByName(args[0]);

			if(adr.isAnyLocalAddress()){
                System.out.println(adr+" is Local Address");
            }

			if(adr.isLoopbackAddress()){
                System.out.println(adr+" is Loopback address ");
            }

			if(adr.isLinkLocalAddress()){
                System.out.println(adr+" is Link local Address");
            }

			if(adr.isSiteLocalAddress()){
                System.out.println(adr+" is Site Local Address");
            }


			if(adr.isMulticastAddress()){
				if(adr.isMCGlobal()){
                    System.out.println(adr+" is Multicast Global Address ");
                }

				if(adr.isMCOrgLocal()){
                    System.out.println(adr+" is Multicast organizational local");
                }

				if(adr.isMCLinkLocal()){
                    System.out.println(adr+" is MC Link Local Address");
                }

				if(adr.isMCSiteLocal()){
                    System.out.println(adr+" is MC Site Local Address");
                }

				if(adr.isMCNodeLocal()){
                    System.out.println(adr+" is MC Node Local Address");
                }
			}

			else{
                System.out.println(adr+" is a unicast address");
            }
		}
        
		catch(UnknownHostException ex){
            System.out.println("Unable to resolve"+args[0]);
        }
	}
    
}
