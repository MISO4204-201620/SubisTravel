package co.com.tauLabs.service.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
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

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.model.Item;
import co.com.tauLabs.service.IItemService;

@Path("/items")
@RequestScoped
public class ItemServiceRS{

	final static Logger logger = Logger.getLogger(ItemServiceRS.class);
	
	@EJB private IItemService itemService;
	
	public ItemServiceRS() {}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public PaginateDTO filtrados(FilterDTO filters){
		logger.debug("CR iniciando servicio itemsFiltrados()");
		try {
			return itemService.filtrados(filters);
		} catch (Exception e) {
			logger.error("CR Error consultando items por filtro, causa: "+e.getMessage());
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Item obtenerItemPorId(@PathParam("id") int id){
		logger.info("obtenerItemPorId Services REST");
		try {
			return itemService.obtenerItemPorId((long) id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/permiteCalificarItem/{idUsuario}")
	public Boolean permiteCalificarItemPorUsuario(@PathParam("id") long id,@PathParam("idUsuario") long idUsuario){
		logger.info("obtenerItemPorId Services REST");
		try {
			return itemService.permiteCalificarItemPorUsuario(id, idUsuario);
		} catch (Exception e) {
			return null;
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("crear")
	public Response crearItem(Item item){
		try{
			itemService.crearItem(item);
			return Response.ok().entity(item).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/publicar")
	public Item publicarItem(@PathParam("id") long id){
		logger.info("obtenerItemPorId Services REST");
		try {
			return itemService.publicarItem(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}/actualizar")
	public Response actualizarItem(@PathParam("id") long id,Item item){
		try{
			itemService.actualizarItem(id, item);
			return Response.ok().entity(item).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
