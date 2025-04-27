package Proxy_Selector;

import java.io.IOException; 
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.ProxySelector;
import java.net.URISyntaxException;
import java.util.*;

public class MyProxySelector extends ProxySelector{
	public List<Proxy> select(URI uri){
		List<Proxy> proxiess= new ArrayList<Proxy>();
		if(!"http".equalsIgnoreCase(uri.getScheme())){
			proxiess.add(Proxy.NO_PROXY);}
		else{
			SocketAddress sa = new InetSocketAddress("example.proxy.com" , 8000);
			Proxy pr = new Proxy(Proxy.Type.HTTP, sa);
			proxiess.add(pr);	}
		return proxiess;}
	public void connectFailed(URI uri, SocketAddress address, IOException ex){
		System.out.println("unable to connect to proxy");}



	public static void main(String[] args) throws IOException,URISyntaxException{
		MyProxySelector MPS = new MyProxySelector();
		ProxySelector.setDefault(MPS);
		System.out.println("Default proxy: "+MPS);
		URI ur1 = new URI("urn://www.google.com/home/index.html?q=question#FAQ");
		List<Proxy> p1 = MPS.select(ur1);
		System.out.println("Proxy Server is: "+p1.get(0));	
	}
}

