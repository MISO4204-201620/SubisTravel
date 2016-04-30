package co.com.tauLabs.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IItemDao;
import co.com.tauLabs.dto.ReportBusquedaDTO;
import co.com.tauLabs.dto.ReportConsultaDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.service.IReportService;

@Stateless
@Named
public class ReporteService implements IReportService,Serializable {

	final static Logger logger = Logger.getLogger(ReporteService.class);

	private static final long serialVersionUID = 1L;

	@EJB private IItemDao itemDao;

	public ReporteService() {
		
    }

	@Override
	public List<ReportBusquedaDTO> reporteBusquedaItems(long idUsuario) throws ServiceEJBException {
		logger.debug("CS iniciando metodo listar()");
		try{
			return itemDao.reporteBusquedaItems(idUsuario);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando los catalogos, causa: "+e.getMessage());
		}
	}
	
	@Override
	public List<ReportConsultaDTO> reporteConsultaItems(long idUsuario) throws ServiceEJBException {
		logger.debug("CS iniciando metodo listar()");
		try{
			return itemDao.reporteConsultaItems(idUsuario);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando los catalogos, causa: "+e.getMessage());
		}
	}

	
}
