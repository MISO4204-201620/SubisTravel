package co.com.tauLabs.service.rest;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import co.com.tauLabs.dto.ProductTypeDTO;
import co.com.tauLabs.service.IConfigService;


@Path("/config")
@RequestScoped
public class ConfigServiceRS{

	final static Logger logger = Logger.getLogger(ConfigServiceRS.class);
	
	public ConfigServiceRS() {}

	@EJB private IConfigService configService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("front/feature")
	public ProductTypeDTO getFrontFeature(){
		logger.debug("CR Iniciando Servicio RS getFrontFeature()");
		try {
			
			return configService.getProperty("front.feature");
		} catch (Exception e) {
			logger.error("CR Error consultando el parámetro de configuración front.feature: "+e.getMessage());
			return null;
		}
	}
	
}
