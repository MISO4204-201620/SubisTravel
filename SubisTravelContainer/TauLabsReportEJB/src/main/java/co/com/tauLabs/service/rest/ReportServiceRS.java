package co.com.tauLabs.service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import co.com.tauLabs.dto.ReportBusquedaDTO;
import co.com.tauLabs.dto.ReportConsultaDTO;
import co.com.tauLabs.service.IReportService;

@Path("/reportes")
@RequestScoped
public class ReportServiceRS{

	final static Logger logger = Logger.getLogger(ReportServiceRS.class);
	
	@EJB private IReportService reportService;
	
	public ReportServiceRS() {}

	@GET
	@Path("usuarios/{idUsuario}/items/busquedas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReportBusquedaDTO> reporteBusquedaItems(@PathParam("idUsuario") long idUsuario){
		logger.debug("CR Iniciando Servicio RS reporteBusquedaItems()");
		try {
			return reportService.reporteBusquedaItems(idUsuario);
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Path("usuarios/{idUsuario}/items/consultas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReportConsultaDTO> reporteConsultaItems(@PathParam("idUsuario") long idUsuario){
		logger.debug("CR Iniciando Servicio RS reporteConsultaItems()");
		try {
			return reportService.reporteConsultaItems(idUsuario);
		} catch (Exception e) {
			return null;
		}
	}
	
}
