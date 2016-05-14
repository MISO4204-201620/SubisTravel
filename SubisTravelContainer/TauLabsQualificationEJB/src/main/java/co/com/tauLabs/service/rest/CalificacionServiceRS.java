package co.com.tauLabs.service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.interceptor.Interceptors;
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

import co.com.tauLabs.enums.ServiciosActivosEnum;
import co.com.tauLabs.model.Calificacion;
import co.com.tauLabs.service.ICalificacionService;
import interceptors.QrInterceptor;;

@Path("/calificaciones")
@RequestScoped
public class CalificacionServiceRS {

	final static Logger logger = Logger.getLogger(CalificacionServiceRS.class);

	@EJB
	private ICalificacionService calificacionService;

	public CalificacionServiceRS() {
	}

	@Path("/items/{idItem}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarCalificacionItem(@PathParam("idItem") Long idItem, Calificacion calificacion) {
		try {
			if (!ServiciosActivosEnum.COMMENTS_AND_RATINGS.getValue())
				throw new Exception("El servicio no ha sido agregado a su paquete");
			calificacion.setIdItem(idItem);
			calificacionService.agregarCalificacion(calificacion);
			return Response.ok().entity(calificacion).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Path("/catalogos/{idCatalogo}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarCalificacionCatalogo(@PathParam("idCatalogo") Long idCatalogo, Calificacion calificacion) {
		try {
			if (!ServiciosActivosEnum.COMMENTS_AND_RATINGS.getValue())
				throw new Exception("El servicio no ha sido agregado a su paquete");
			calificacion.setIdCatalogo(idCatalogo);
			calificacionService.agregarCalificacion(calificacion);
			return Response.ok().entity(calificacion).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Path("/items/{idItem}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Calificacion> obtenerCalificacionesPorItem(@PathParam("idItem") Long idItem) {
		logger.debug("CR iniciando servicio obtenerCalificacionesPorItem()");
		try {
			if (!ServiciosActivosEnum.COMMENTS_AND_RATINGS.getValue())
				throw new Exception("El servicio no ha sido agregado a su paquete");
			return calificacionService.obtenerCalificacionesPorItem(idItem);
		} catch (Exception e) {
			logger.error("CR Error consultando calificaciones por item, causa: " + e.getMessage());
			return null;
		}
	}

	@Path("/catalogos/{idCatalogo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Calificacion> obtenerCalificacionesPorCatalogo(@PathParam("idCatalogo") Long idCatalogo) {
		logger.debug("CR iniciando servicio obtenerCalificacionesPorCatalogo()");
		try {
			if (!ServiciosActivosEnum.COMMENTS_AND_RATINGS.getValue())
				throw new Exception("El servicio no ha sido agregado a su paquete");
			return calificacionService.obtenerCalificacionesPorCatalogo(idCatalogo);
		} catch (Exception e) {
			logger.error("CR Error consultando calificaciones por catalogo, causa: " + e.getMessage());
			return null;
		}
	}
}
