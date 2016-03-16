package rslive;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import model.UV;


public class RSClient {
	
	public static void main(String[] args){
				
		ClientConfig config = new DefaultClientConfig();		
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		
		//System.out.println(service.path("rest").path("census").accept(MediaType.TEXT_PLAIN).get(String.class)); 
		System.out.println(service.path("rest").path("census").accept(MediaType.APPLICATION_JSON).get(String.class)); 
	
	}
	
	private static URI getBaseURI() {
		URI uri =
		 UriBuilder.fromUri("http://localhost:8080/RESTTest").build();
		return uri;
	}

}
