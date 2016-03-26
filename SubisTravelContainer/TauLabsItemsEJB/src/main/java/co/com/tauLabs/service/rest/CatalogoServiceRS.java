package co.com.tauLabs.service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import co.com.tauLabs.model.Catalogo;
import co.com.tauLabs.service.ICatalogoService;

@Path("/catalogos")
@RequestScoped
public class CatalogoServiceRS{

	final static Logger logger = Logger.getLogger(CatalogoServiceRS.class);
	
	@EJB private ICatalogoService catalogoService;
	
	public CatalogoServiceRS() {}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Catalogo> listar(){
		logger.debug("CR Iniciando Servicio RS listar()");
		try {
			return catalogoService.listar();
		} catch (Exception e) {
			return null;
		}
	}
	
}
