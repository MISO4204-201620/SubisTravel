package co.com.tauLabs.service.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Calificacion;
import co.com.tauLabs.service.IQualificationService;;

@Path("/calificaciones")
@RequestScoped
public class QualificationServiceRS {

	final static Logger logger = Logger.getLogger(QualificationServiceRS.class);
	
	@EJB private IQualificationService qualificationService;
	
	public QualificationServiceRS() {}
	
	@Path("/items/{idItem}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarCalificacionItem(@PathParam("idItem")Long idItem, Calificacion calificacion){
		try{
			if(idItem==null)return Response.status(Status.UNAUTHORIZED).build();
			calificacion.setIdItem(idItem);
			qualificationService.agregarCalificacion(calificacion);
			return Response.ok().entity(calificacion).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Path("/catalogos/{idCatalogo}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarCalificacionCatalogo(@PathParam("idCatalogo")Long idCatalogo, Calificacion calificacion){
		try{
			if(idCatalogo==null)return Response.status(Status.UNAUTHORIZED).build();
			calificacion.setIdCatalogo(idCatalogo);
			qualificationService.agregarCalificacion(calificacion);
			return Response.ok().entity(calificacion).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
