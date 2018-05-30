//This is a basic example on how to do a basic connection Java-MongoDB
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;



@Path("/")
public class Resource {
	
	Service userService = new Service();

	@POST
	@Path("/users")
	public Response postUser(String body) {
		userService.saveUser(body);
		return Response.status(200).build();
	}
	
	@PUT
	@Path("/users/{email}")
	public Response updatetUser(@PathParam("email") String email, String body) {
		userService.updateUser(body, email);
		return Response.status(200).build();
	}
	
	
}
