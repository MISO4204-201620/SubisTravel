package co.com.tauLabs.controller;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/login")
public class AutenticacionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{username}/{password}")
	public String autenticar(@PathParam("username") String username,@PathParam("password") String password){
		return "has sido autenticado";
	}
	
}
