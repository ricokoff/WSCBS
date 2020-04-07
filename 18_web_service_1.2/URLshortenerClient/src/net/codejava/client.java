package net.codejava;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
 
import org.glassfish.jersey.client.ClientConfig;
public class client {

    static String uri2 = "http://localhost:8080/RESTcalculator/rest/shortener";
    static String uri = "http://localhost:8080/RESTURLshortener/rest/shortener";
    static ClientConfig config = new ClientConfig();
    static Client client = ClientBuilder.newClient(config);
	static boolean isKilled = false;
	public static String sendGetRequest(String request) {
		WebTarget target = client.target(uri).path("urls").path(request);
        return target.request(MediaType.TEXT_PLAIN)
                .accept(MediaType.TEXT_PLAIN)
                .get(String.class);
	}
	
	public static String sendEmptyGetRequest() {
		WebTarget target = client.target(uri);
        return target.request(MediaType.TEXT_PLAIN)
                .accept(MediaType.TEXT_PLAIN)
                .get(String.class);
	}
	
	public static String sendPostRequest(String request) {
		WebTarget target = client.target(uri);
		return target.request(MediaType.TEXT_PLAIN)
         .accept(MediaType.APPLICATION_JSON)
         .post(Entity.entity(request, MediaType.TEXT_PLAIN), String.class);
	}
	
	public static String sendPutRequest(String id, String newURL) {
		WebTarget target = client.target(uri).path("urls").path(id);
        return target.request(MediaType.TEXT_PLAIN)
                .accept(MediaType.TEXT_PLAIN)
                .put(Entity.entity(newURL, MediaType.TEXT_PLAIN), String.class);
	}
	
	public static String sendDeleteRequest(String id) {
		WebTarget target = client.target(uri).path("urls").path(id);;
        return target.request(MediaType.TEXT_PLAIN)
                .accept(MediaType.TEXT_PLAIN)
                .delete(String.class);
	}
	
	public static String sendEmptyDeleteRequest() {
		WebTarget target = client.target(uri);
        return target.request(MediaType.TEXT_PLAIN)
                .accept(MediaType.TEXT_PLAIN)
                .delete(String.class);
	}
	
	
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintStream out = new PrintStream(System.out);
		out.println("************************************************************************\n"
				+ "Welcome to the URLshortener client!\n"
				+ "Usage: [Command] {Identifier} {URL}\n"
				+ "Available commands: [GET, POST, PUT, DELETE]\n"
				+ "Command usage is as follows:\n"
				+ "To get a new shortURL ID: POST {URL}\n"
				+ "To retrieve the URL of a shortURL ID: GET {IDENTIFIER}\n"
				+ "To retrieve all the shortURL ID's currently in the database: GET {}\n"
				+ "To replace the URL at a specific shortURL ID: PUT {IDENTIFIER} {URL}\n"
				+ "To delete a shortURL ID: DELETE {IDENTIFIER\n"
				+ "To delete all the shortURL's: DELETE {}\n"
				+ "To exit this program: EXIT\n"
				+ "************************************************************************");
    	while(!isKilled) {
    	     String input = "";
			try {
				out.println("\nType your command here: ");
				input = reader.readLine();
			} catch (IOException e) {
				out.println("No input received!");
				e.printStackTrace();
			}
    	     if(input.toUpperCase().equals("EXIT")){isKilled = true;}
    	     else {
    	    	 Scanner scanner = new Scanner(input);
    	    	 String command = scanner.next();
    	    	 if(command.toUpperCase().equals("GET")) {
    	    		 if(scanner.hasNext()) {
    	    			 String id = scanner.next();
    	    			 out.println(sendGetRequest(id));
    	    		 } else {out.println(sendEmptyGetRequest());}
    	    	 } else if(command.toUpperCase().equals("POST")){
    	    		 if(scanner.hasNext()) {
    	    			 String url = scanner.next();
    	    			 out.println(sendPostRequest(url));
    	    		 } else {out.println("Invalid input. Usage: POST {URL}");}
    	    	 } else if(command.toUpperCase().equals("PUT")){
    	    		 if(scanner.hasNext()) {
    	    			 String id = scanner.next();
    	    			 if(scanner.hasNext()) {
    	    				 String url = scanner.next();
    	    				 out.println(sendPutRequest(id, url));
    	    			 } else {out.println("Invalid input. Usage: PUT {Identifier} {new URL}");}
    	    		 } else {out.println("Invalid input. Usage: PUT {Identifier} {new URL}");} 
    	    	 } else if(command.toUpperCase().equals("DELETE")){
    	    		 if(scanner.hasNext()) {
    	    			 String id = scanner.next();	
    	    			 out.println(sendDeleteRequest(id));
    	    		 } 	else{out.println(sendEmptyDeleteRequest());}
    	    	 }else {out.println("Usage: [Command] {Identifier} {URL}\nAvailable commands: [GET, POST, PUT, DELETE]");}
    	     scanner.close();
    	     }
    	}	
	client.close();
    out.println("Client has terminated!");
    }
}

