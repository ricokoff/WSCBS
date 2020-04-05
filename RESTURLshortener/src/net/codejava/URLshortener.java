package net.codejava;
 
 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Path("/shortener")
public class URLshortener {
	
	static int currentID = 1;
	static Map<String, Integer> idMap = new HashMap<String, Integer>();
	
	public boolean validURL(String url) {
//		  try {
//			     (new java.net.URL(url)).openStream().close();
//			     return true;
//			  } catch (Exception ex) {
//			  return false;}
//		}
       String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
       return IsMatch(url,regex);
    }
   private static boolean IsMatch(String s, String pattern) {
       try {
           Pattern patt = Pattern.compile(pattern);
           Matcher matcher = patt.matcher(s);
           return matcher.matches();
       } catch (RuntimeException e) {
       return false;
       }  
   }
   
	public int createID(String longUrl) {
		if(idMap.containsKey(longUrl)) {
			return idMap.get(longUrl);			
		}else {
		idMap.put(longUrl,currentID);
		currentID = currentID + 1;
		return idMap.get(longUrl);
		}
	}
	
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String getrequest(String URL) {
    	
    	
    	return "TEST";
    }
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String postrequest(String URL) {
    	if(!validURL(URL)) {
    		return "HTTP: " + Response.Status.BAD_REQUEST.getStatusCode() + " " + Response.Status.BAD_REQUEST + "\n ERROR";}
    	else {
    		int id = createID(URL);
    		return "HTTP: " + Response.Status.CREATED.getStatusCode() + " " + Response.Status.CREATED + "\nYour ID is: " + id;}
    	}	 
        
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String putrequest(String URL) {
        return "This is a PUT request.";
    }
    
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleterequest(String URL) {
        return "This is a DELETE request.";
    }
}