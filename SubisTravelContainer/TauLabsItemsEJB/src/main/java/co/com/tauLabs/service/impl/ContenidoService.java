package co.com.tauLabs.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IContenidoDao;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.exception.ValidationException;
import co.com.tauLabs.model.Contenido;
import co.com.tauLabs.service.IContenidoService;

@Stateless
@Named
public class ContenidoService implements IContenidoService,Serializable {

	final static Logger logger = Logger.getLogger(ContenidoService.class);

	private static final long serialVersionUID = 1L;

	@EJB private IContenidoDao contenidoDao;

	public ContenidoService() {
		
    }
	
	@Override
	public List<Contenido> byItem(Long idItem) throws ServiceEJBException {
		logger.debug("CS iniciando metodo byItem()");
		try{
			if(idItem==null) throw new ValidationException("El item ingresado es nulo");
			return contenidoDao.byItem(idItem);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Error consultando contenidos de un item, causa, causa: "+e.getMessage());
		}
		
	}
	
}
