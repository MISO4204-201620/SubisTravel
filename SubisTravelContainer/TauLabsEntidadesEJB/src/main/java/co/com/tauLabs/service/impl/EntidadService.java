package co.com.tauLabs.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import co.com.tauLabs.dao.IEntidadDao;
import co.com.tauLabs.dao.IGenericDao;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
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
	public List<Entidad> obtenerEntidadesPorTipo(Long idTipo) throws ServiceEJBException {
		logger.debug("CS iniciando metodo obtenerEntidadesPorTipo()");
		try{
			if(idTipo==null) throw new Exception("Los filtros ingresados son nulos");
			return entidadDao.obtenerEntidadesPorTipo(idTipo);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando entidades por tipo, causa: "+e.getMessage());
		}
	}
	
}
