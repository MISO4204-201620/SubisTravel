package co.com.tauLabs.service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
}
