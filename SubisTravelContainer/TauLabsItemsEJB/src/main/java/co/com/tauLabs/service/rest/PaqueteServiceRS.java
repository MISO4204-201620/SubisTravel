package co.com.tauLabs.service.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import co.com.tauLabs.dto.PaqueteDTO;
import co.com.tauLabs.service.IPaqueteService;

@Path("/paquetes")
@RequestScoped
public class PaqueteServiceRS{

	final static Logger logger = Logger.getLogger(PaqueteServiceRS.class);
	

	@EJB private IPaqueteService paqueteService;
	
	public PaqueteServiceRS() {
		
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("guardar")
	public Response guardarPaquete(PaqueteDTO paquete){
		try{
			paquete = paqueteService.guardarPaquete(paquete);
			return Response.ok().entity(paquete).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("items/{id}")
	public PaqueteDTO obtenerPaquetePorIdItemPaquete(@PathParam("id") long id){
		logger.info("obtenerItemPorId Services REST");
		try {
			return paqueteService.obtenerPaquetePorIdItemPaquete(id);
		} catch (Exception e) {
			return null;
		}
	}
}
