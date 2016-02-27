package co.com.tauLabs.service.rest;

import org.jboss.logging.Logger;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class CORSFilter implements ContainerResponseFilter {

	final static Logger logger = Logger.getLogger(CORSFilter.class);

	
  @Override
  public ContainerResponse filter(final ContainerRequest request, final ContainerResponse   response) { 
	  logger.info("Se ha ingresado al filtro de request");
	  response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
      response.getHttpHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
      response.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
      response.getHttpHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
      return response;
 }
}