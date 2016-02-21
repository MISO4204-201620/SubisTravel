package co.com.tauLabs.service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.model.Entidad;
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
	public List<Item> filtrados(FilterDTO filters){
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
	
}
