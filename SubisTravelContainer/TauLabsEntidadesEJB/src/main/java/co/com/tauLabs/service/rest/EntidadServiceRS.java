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

import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.service.IEntidadService;

@Path("/entidades")
@RequestScoped
public class EntidadServiceRS{

	final static Logger logger = Logger.getLogger(EntidadServiceRS.class);
	
	@EJB private IEntidadService entidadService;
	
	public EntidadServiceRS() {}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Entidad encontrarPorId(@PathParam("id") int id){
		logger.info("encontrarPorId");
		try {
			return entidadService.obtenerPorId((long) id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Entidad> listar(){
		logger.info("listar actualizado");
		try {
			return entidadService.listar();
		} catch (Exception e) {
			return null;
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarEntidad(Entidad entidad){
		try{
			entidadService.guardar(entidad);
			return Response.ok().entity(entidad).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response modificarPersona(@PathParam("id") int id, Entidad personaModificada){
		try{
			Entidad persona = entidadService.obtenerPorId((long) id);
			if(persona != null){
				entidadService.modificar(personaModificada);
				return Response.ok().entity(personaModificada).build();
			}
			else{
				return Response.status(Status.NOT_FOUND).build();
			}
			
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response eliminarPersonaPorId(@PathParam("id") int id){
		try{
//			personaService.eliminar(new Entidad((long) id));
			return Response.ok().build();
		}
		catch(Exception e){
			return Response.status(404).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("porTipo/{idTipo}")
	public List<Entidad> obtenerEntidadesPorTipo(@PathParam("idTipo") int idTipo){
		logger.info("obtenerEntidadesPorTipo Services REST");
		try {
			return entidadService.obtenerEntidadesPorTipo((long) idTipo);
		} catch (Exception e) {
			return null;
		}
	}
	
}
