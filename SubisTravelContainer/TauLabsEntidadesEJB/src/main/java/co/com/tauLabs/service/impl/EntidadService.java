package co.com.tauLabs.service.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import co.com.tauLabs.dao.IEntidadDao;
import co.com.tauLabs.dao.IGenericDao;
import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.exception.ValidationException;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.service.IEntidadService;

@Stateless
@Named
public class EntidadService extends GenericService<Entidad, Long> implements IEntidadService {

	private static final long serialVersionUID = 1L;

	@Inject private IEntidadDao entidadDao;

	public EntidadService() {
		
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostConstruct
	public void entidadService(){
		super.genericDao = (IGenericDao) entidadDao;
	}
	
	@Override
	public PaginateDTO filtrados(FilterDTO filtros) throws ServiceEJBException {
		logger.debug("CS iniciando metodo filtrados()");
		try{
			if(filtros==null)throw new ValidationException("El filtro ingresado es nulo");
			return entidadDao.filtrados(filtros);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando entidades por filtros, causa: "+e.getMessage());
		}
		
	}
	
}
