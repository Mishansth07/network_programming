import java.net.URI;
import java.net.URISyntaxException;
public class uri_resolver{
	public static void main(String[] args){
		try{
			URI absolute = new URI("http://www.java.com/");
			URI relative = new URI("FAQ/faq.html");
			URI resolved = absolute.resolve(relative);
			System.out.println("the new resolved absolute URL is"+resolved);

            
			URI absolute1= new URI("http://www.java.com/index/index.html");
			URI domain = new URI("http://www.java.com/");
			URI revitalized = domain.relativize(absolute1);
			System.out.println("The new relative url is: "+revitalized);	
		}
		catch(URISyntaxException u){System.out.println("URI syntax Error");}
	}
}
