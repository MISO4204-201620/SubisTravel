package co.com.tauLabs.service.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import co.com.tauLabs.model.Pregunta;
import co.com.tauLabs.service.IPreguntaService;

@Path("/preguntas")
@RequestScoped
public class PreguntaServiceRS{

	final static Logger logger = Logger.getLogger(PreguntaServiceRS.class);
	
	@EJB private IPreguntaService preguntaService;
	
	public PreguntaServiceRS() {}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/registrar")
	public Response registrarPregunta(Pregunta pregunta){
		try{
			preguntaService.registrarPregunta(pregunta);
			return Response.ok().entity(pregunta).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
