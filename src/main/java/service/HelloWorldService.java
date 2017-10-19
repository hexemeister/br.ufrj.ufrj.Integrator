package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldService {

	@GET
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	public String getIt() {
		return "Olá Mundo!!!";
	}
	
}
