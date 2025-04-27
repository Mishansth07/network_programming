package Spam_Check;
import java.net.UnknownHostException;
import java.net.InetAddress;
public class spam_check{
	public static final String SpamHaus = "sbl.spamhaus.org";
	public static void main(String[] args){
		for(String arg:args){
			if(isSpammer(arg)){
				System.out.println(arg+" is known Spammer");}
			else{
				System.out.println(arg+" belongs to legitimate address");}
		}
	} 
	public static boolean isSpammer(String ar){
		try{
			InetAddress ia = InetAddress.getByName(ar);
			byte[] quad = ia.getAddress();
			String query = SpamHaus;
			for(byte octet:quad){
				int a = octet<0?octet+256:octet;
				query = a+"."+query;
			}
			InetAddress.getByName(query);
			return true;
		}
		catch(UnknownHostException uhe){
			return false;
		}
	}	
}

    

