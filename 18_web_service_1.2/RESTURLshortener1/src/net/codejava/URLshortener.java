package net.codejava;
 
 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Path("/shortener")
public class URLshortener {
	

	static Map<String, String> idURLMap = new HashMap<String, String>();
	static Map<String, String> URLidMap = new HashMap<String, String>();
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
	while (count-- != 0) {
	int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
	builder.append(ALPHA_NUMERIC_STRING.charAt(character));
	}
	return builder.toString();
	}

	public boolean validURL(String url) {
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
   
   private static String createUniqueCode(int count) {
	   String code = randomAlphaNumeric(6);
	   if(!idURLMap.containsKey("lin.k" + code)){
		   return code;
	   } else {
		   return createUniqueCode(6);
	   }
   }
   
	public String createID(String longUrl) {
		if(URLidMap.containsKey(longUrl)) {
			return URLidMap.get(longUrl);			
		}else {
			String code = createUniqueCode(6);
		idURLMap.put(("lin.k" + code),longUrl);
		URLidMap.put(longUrl,("lin.k" + code));
		return URLidMap.get(longUrl);
		}
	}
	
    @GET
    @Path("/urls/{url}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getrequest(@PathParam("url") String URL) {
    	if(idURLMap.containsKey(URL)) {
    		return "HTTP: " + Response.Status.MOVED_PERMANENTLY.getStatusCode() + " " + Response.Status.MOVED_PERMANENTLY + "\n" + idURLMap.get(URL);}
    	else {
    		return "HTTP: " + Response.Status.NOT_FOUND.getStatusCode() + " " + Response.Status.NOT_FOUND + "\nshortURL: \"" + URL + "\" cannot be found in our database.";}   
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String emptygetrequest() {
    	return "HTTP: " + Response.Status.OK.getStatusCode() + " " + Response.Status.OK + "\n" +
    				idURLMap.keySet();
    }
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String postrequest(String URL) {
    	if(!validURL(URL)) {
    		return "HTTP: " + Response.Status.BAD_REQUEST.getStatusCode() + " " + Response.Status.BAD_REQUEST + "\nThis is not a valid URL. A valid URL has the following format: http://www.{domain name}.{extension}";}
    	else {
    		String id = createID(URL);
    		return "HTTP: " + Response.Status.CREATED.getStatusCode() + " " + Response.Status.CREATED + "\nYour ID is: " + id;}
    	}	 
        
    @PUT
    @Path("/urls/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String putrequest(@PathParam("id") String id, String newURL) {
    	if(!idURLMap.containsKey(id)) {
    		return "HTTP: " + Response.Status.NOT_FOUND.getStatusCode() + " " + Response.Status.NOT_FOUND + "\nThe shortURL \""+id+"\" cannot be found in our database. Please try again with a valid URL.";
    	} else if (id.length() != 11) {
    		return "HTTP: " + Response.Status.BAD_REQUEST.getStatusCode() + " " + Response.Status.BAD_REQUEST + "\nThe shortURL should have the following format: \"lin.k{******}\" where * only consists of alphanumeric values.";
    	} else if (!validURL(newURL)){
    		return "HTTP: " + Response.Status.BAD_REQUEST.getStatusCode() + " " + Response.Status.BAD_REQUEST + "\nThis is not a valid URL. A valid URL has the following format: http://www.{domain name}.{extension}";}
    	  else {
    		String oldURL = idURLMap.replace(id, newURL);
    		return "HTTP: "+Response.Status.OK.getStatusCode()+" "+Response.Status.OK+"\nShortURL \""+id+" \" is set from \""+oldURL+"\" to \""+newURL+"\"";
    	}
	
    }
    
    @DELETE
    @Path("/urls/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleterequest(@PathParam("id") String id) {
    	if(!idURLMap.containsKey(id)) {
    		return "HTTP: " + Response.Status.NOT_FOUND.getStatusCode() + " " + Response.Status.NOT_FOUND + "\nThe shortURL \""+id+"\" cannot be found in our database. Please try again with a valid URL.";
    	} else {
    		String longURL = idURLMap.get(id);
    		idURLMap.remove(id);
    		URLidMap.remove(longURL);
            return"HTTP: "+Response.Status.NO_CONTENT.getStatusCode()+" "+Response.Status.NO_CONTENT +"\nThe shortURL \""+id+"\" is succesfully removed from the database";
            
    	}

    }
    
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String emptydeleterequest() {
    	idURLMap.clear();
    	URLidMap.clear();
        return"HTTP: "+Response.Status.NO_CONTENT.getStatusCode()+" "+Response.Status.NO_CONTENT +"\nAll URL mappings are succesfully removed!";
    }
}