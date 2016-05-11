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

import co.com.tauLabs.dto.MensajeDTO;
import co.com.tauLabs.service.IMensajeService;

@Path("/mensajes")
@RequestScoped
public class MensajeServiceRS{

	final static Logger logger = Logger.getLogger(MensajeServiceRS.class);
	
	@EJB private IMensajeService mensajeService;
	
	public MensajeServiceRS() {}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/enviar")
	public Response enviarMensaje(MensajeDTO mensaje){
		try{
			mensajeService.enviarMensaje(mensaje);
			return Response.ok().entity(mensaje).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Path("/usuarios/{idUsuario}/recibidos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<MensajeDTO> obtenerMensajesRecibidosPorUsuario(@PathParam("idUsuario")Long idUsuario){
		logger.debug("CR iniciando servicio obtenerMensajesRecibidosPorUsuario()");
		try{
			return mensajeService.obtenerMensajesRecibidosPorUsuario(idUsuario);
		}catch(Exception e){
			logger.error("CR Error consultando Mensajes recibidos por usuario, causa: "+e.getMessage());
			return null;
		}
	}
	
	@Path("/usuarios/{idUsuario}/enviados")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<MensajeDTO> obtenerMensajesEnviadosPorUsuario(@PathParam("idUsuario")Long idUsuario){
		logger.debug("CR iniciando servicio obtenerMensajesEnviadosPorUsuario()");
		try{
			return mensajeService.obtenerMensajesEnviadosPorUsuario(idUsuario);
		}catch(Exception e){
			logger.error("CR Error consultando Mensajes enviados por usuario, causa: "+e.getMessage());
			return null;
		}
	}
}
