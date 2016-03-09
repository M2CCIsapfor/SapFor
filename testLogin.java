
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

public class testLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login nouveauLogin;
		Login loginT;
		
		// Get access to the service object
		ClientConfig config = new DefaultClientConfig();		
		
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI()+"/login?login=Vicky&password=vi");
		
		// Get all products
		
		loginT = service.accept(MediaType.APPLICATION_JSON).get(new GenericType<Login>(){});            

		afficher(loginT);
	}
/*        r = c.resource(URL + "/" + user.getId());  
        user = r.type(MediaType.APPLICATION_JSON_TYPE)  
                .accept(MediaType.APPLICATION_JSON_TYPE)  
                .get(User.class);  */

private static void afficher(Login login) {
	
		System.err.println(login.getLogin());
	
}

private static java.net.URI getBaseURI() {
	java.net.URI uri =
	 UriBuilder.fromUri("http://localhost:8080/rest").build();
	return uri;
}
}
