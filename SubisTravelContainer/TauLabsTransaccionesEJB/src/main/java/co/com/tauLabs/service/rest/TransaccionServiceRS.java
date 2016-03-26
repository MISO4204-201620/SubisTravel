package co.com.tauLabs.service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import co.com.tauLabs.dto.PaymentDTO;
import co.com.tauLabs.dto.ShoppingItem;
import co.com.tauLabs.model.Transaccion;
import co.com.tauLabs.service.ITransaccionService;

@Path("/transacciones")
@RequestScoped
public class TransaccionServiceRS{

	final static Logger logger = Logger.getLogger(TransaccionServiceRS.class);
	
	@EJB private ITransaccionService transaccionService;
	
	public TransaccionServiceRS() {}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/agregarACarrito")
	public Response agregarACarrito(ShoppingItem shoppingItem){
		logger.info("agregarACarrito");
		try {
			transaccionService.agregarItemACarrito(shoppingItem);
			return Response.ok().entity(shoppingItem).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DELETE
	@Path("/eliminarDeCarrito/{idTransaccion}")
	public Response eliminarDeCarrito(@PathParam("idTransaccion") int idTransaccion){
		logger.info("eliminarDeCarrito");
		try {
			transaccionService.eliminarDeCarrito(Integer.valueOf(idTransaccion).longValue());
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/enCarrito/{idEntidad}")
	public List<Transaccion> enCarritoPorEntidad(@PathParam("idEntidad") int idEntidad){
		logger.info("itemsEnCarrito");
		try {
			List<Transaccion> transacciones =  transaccionService.enCarritoPorEntidad(Integer.valueOf(idEntidad).longValue());
			return transacciones;
		} catch (Exception e) {
			return null;
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/realizarCompra")
	public Response realizarCompra(PaymentDTO paymentDTO){
		logger.info("realizarCompra");
		try {
			transaccionService.realizarCompra(paymentDTO.getIdsTransacction());
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getalltransaction")
	public List<Transaccion> getAllTransaction(){
		logger.info("getalltransaction");
		try {
			List<Transaccion> transacciones =  transaccionService.getAllTransactions();
			return transacciones;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/compras/{idUsuario}")
	public List<Transaccion> obtenerCompras(@PathParam("idUsuario") int idUsuario){
		logger.info("RS obtenerCompras");
		try {
			return transaccionService.obtenerCompras(Integer.valueOf(idUsuario).longValue());
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/ventas/{idEntidad}")
	public List<Transaccion> obtenerVentas(@PathParam("idEntidad") int idEntidad){
		logger.info("RS obtenerVentas");
		try {
			return transaccionService.obtenerVentas(Integer.valueOf(idEntidad).longValue());
		} catch (Exception e) {
			return null;
		}
	}

}
