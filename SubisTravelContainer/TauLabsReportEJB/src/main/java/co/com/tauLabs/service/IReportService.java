package co.com.tauLabs.service;

import java.util.List;

import javax.ejb.Local;

import co.com.tauLabs.dto.ReportBusquedaDTO;
import co.com.tauLabs.dto.ReportConsultaDTO;
import co.com.tauLabs.exception.ServiceEJBException;

@Local
public interface IReportService {
	
	/**
	 * @author OscarMalagòn
	 * @return List of contents by a defined item
	 */
	List<ReportBusquedaDTO> reporteBusquedaItems(long idUsuario) throws ServiceEJBException;
	
	List<ReportConsultaDTO> reporteConsultaItems(long idUsuario) throws ServiceEJBException;

}
