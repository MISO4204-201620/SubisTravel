package co.com.tauLabs.service.impl;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IPaqueteDao;
import co.com.tauLabs.dto.PaqueteDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.service.IPaqueteService;

@Stateless
@Named
public class PaqueteService implements IPaqueteService, Serializable{

	private final static Logger logger = Logger.getLogger(PaqueteService.class);

	private static final long serialVersionUID = 1L;

	@Inject
	private IPaqueteDao paqueteDao;
	
	public PaqueteService() {

	}
	
	@Override
	public PaqueteDTO guardarPaquete(PaqueteDTO paquete) throws ServiceEJBException {
		logger.debug("CS iniciando metodo guardarPaquete()");
		try {
			if (paquete == null)
				throw new Exception("El Objeto ingresado es nulo");
			return paqueteDao.guardarPaquete(paquete);
		} catch (PersistenceEJBException e) {
			throw new ServiceEJBException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceEJBException(
					"CS Ha ocurrido un error guardando Paquete, causa: " + e.getMessage());
		}
	}

	@Override
	public PaqueteDTO obtenerPaquetePorIdItemPaquete(Long idItemPaquete) throws ServiceEJBException {
		logger.debug("CS iniciando metodo obtenerPaquetePorIdItemPaquete()");
		try {
			if (idItemPaquete == null)
				throw new Exception("El ID ingresado es nulo");
			return paqueteDao.obtenerPaquetePorItemPaquete(idItemPaquete);
		} catch (PersistenceEJBException e) {
			throw new ServiceEJBException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceEJBException(
					"CS Ha ocurrido un error consultando Paquete por idItemPaquete, causa: " + e.getMessage());
		}
	}
}
