package net.codejava;
 
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
 
import org.glassfish.jersey.client.ClientConfig;
public class client {

    public static void main(String[] args) {
        String uri = "http://localhost:8080/RESTURLshortener/rest/shortener";
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(uri);
         
        String firstresponse = target.request(MediaType.TEXT_PLAIN)
                    .accept(MediaType.TEXT_PLAIN)
                    .get(String.class);
        
        String secondresponse = target.request(MediaType.TEXT_PLAIN)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity("http://www.google.com", MediaType.TEXT_PLAIN), String.class);
     
        String thirdresponse = target.request(MediaType.TEXT_PLAIN)
                .accept(MediaType.TEXT_PLAIN)
                .put(Entity.entity("test", MediaType.TEXT_PLAIN), String.class);
    
        String fourthresponse = target.request(MediaType.TEXT_PLAIN)
                .accept(MediaType.TEXT_PLAIN)
                .delete(String.class);
    
        
        System.out.println("First response is " + firstresponse);
        System.out.println("Second response is " + secondresponse);
        System.out.println("Third response is " + thirdresponse);
        System.out.println("Fourth response is " + fourthresponse);
    }
	
}
