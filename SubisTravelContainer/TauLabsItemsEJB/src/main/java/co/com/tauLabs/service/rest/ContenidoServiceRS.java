package co.com.tauLabs.service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import co.com.tauLabs.model.Contenido;
import co.com.tauLabs.service.IContenidoService;

@Path("/contenidos")
@RequestScoped
public class ContenidoServiceRS{

	final static Logger logger = Logger.getLogger(ContenidoServiceRS.class);
	
	@EJB private IContenidoService contenidoService;
	
	public ContenidoServiceRS() {}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public List<Contenido> byItem(@PathParam("id") int id){
		logger.debug("CR Iniciando Servicio RS byItem()");
		try {
			return contenidoService.byItem((long) id);
		} catch (Exception e) {
			return null;
		}
	}
	
}
