package co.com.tauLabs.service.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import co.com.tauLabs.dao.IEntidadDao;
import co.com.tauLabs.dao.IGenericDao;
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
	
}
