package co.com.tauLabs.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.ICatalogoDao;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Catalogo;
import co.com.tauLabs.service.ICatalogoService;

@Stateless
@Named
public class CatalogoService implements ICatalogoService,Serializable {

	final static Logger logger = Logger.getLogger(CatalogoService.class);

	private static final long serialVersionUID = 1L;

	@EJB private ICatalogoDao catalogoDao;

	public CatalogoService() {
		
    }

	@Override
	public List<Catalogo> listar() throws ServiceEJBException {
		logger.debug("CS iniciando metodo listar()");
		try{
			return catalogoDao.listar();
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando los catalogos, causa: "+e.getMessage());
		}
	}
	

	
}
