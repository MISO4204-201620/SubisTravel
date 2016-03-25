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
	
	@Path("/items/{idItem}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Pregunta> obtenerPreguntasPorItem(@PathParam("idItem")Long idItem){
		logger.debug("CR iniciando servicio obtenerPreguntasPorItem()");
		try{
			return preguntaService.obtenerPreguntasPorItem(idItem);
		}catch(Exception e){
			logger.error("CR Error consultando Preguntas por item, causa: "+e.getMessage());
			return null;
		}
	}
	
	@Path("/catalogos/{idCatalogo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Pregunta> obtenerPreguntasPorCatalogo(@PathParam("idCatalogo")Long idCatalogo){
		logger.debug("CR iniciando servicio obtenerPreguntasPorCatalogo()");
		try{
			return preguntaService.obtenerPreguntasPorCatalogo(idCatalogo);
		}catch(Exception e){
			logger.error("CR Error consultando Preguntas por catalogo, causa: "+e.getMessage());
			return null;
		}
	}
	
	@Path("/respuestas/{idPregunta}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Pregunta> obtenerPreguntasPorPreguntaPadre(@PathParam("idPregunta")Long idPregunta){
		logger.debug("CR iniciando servicio obtenerPreguntasPorItem()");
		try{
			return preguntaService.obtenerPreguntasPorPreguntaPadre(idPregunta);
		}catch(Exception e){
			logger.error("CR Error consultando Preguntas por pregunta padre, causa: "+e.getMessage());
			return null;
		}
	}
}
