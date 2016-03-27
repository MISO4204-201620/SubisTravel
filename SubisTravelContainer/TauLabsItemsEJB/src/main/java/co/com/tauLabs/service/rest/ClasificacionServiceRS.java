package co.com.tauLabs.service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import co.com.tauLabs.model.Clasificacion;
import co.com.tauLabs.service.IClasificacionService;

@Path("/clasificaciones")
@RequestScoped
public class ClasificacionServiceRS{

	final static Logger logger = Logger.getLogger(ClasificacionServiceRS.class);
	
	@EJB private IClasificacionService clasificacionService;
	
	public ClasificacionServiceRS() {}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Clasificacion> listar(){
		logger.debug("CR Iniciando Servicio RS listar()");
		try {
			return clasificacionService.listar();
		} catch (Exception e) {
			return null;
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("guardar")
	public Response guardar(Clasificacion clasificacion){
		try{
			clasificacionService.guardar(clasificacion);
			return Response.ok().entity(clasificacion).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("modificar")
	public Response modificar(Clasificacion clasificacion){
		try{
			clasificacionService.modificar(clasificacion);
			return Response.ok().entity(clasificacion).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("encontrarPorId/{id}")
	public Clasificacion encontrarPorId(@PathParam("id") int id){
		logger.info("encontrarPorId");
		try {
			return clasificacionService.obtenerPorId((long) id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@DELETE
	@Path("eliminar/{id}")
	public Response eliminarPersonaPorId(@PathParam("id") int id){
		try{
			clasificacionService.eliminar((long)id);
			return Response.ok().build();
		}
		catch(Exception e){
			return Response.status(404).build();
		}
	}
	
}
