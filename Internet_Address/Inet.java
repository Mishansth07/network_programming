import java.net.InetAddress;
import java.net.UnknownHostException;
public class Inet{
public static void main(String args[])
{
try{
InetAddress fohss = InetAddress.getByName("www.java.com");
System.out.println("the host name is:"+fohss.getHostName());
System.out.println("the host ip is:"+fohss.getHostAddress());
}
catch(UnknownHostException uhe){
System.out.println("UnknownHostException occured");
}
}
}