package co.com.tauLabs.service;

import javax.ejb.Local;

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Entidad;

@Local
public interface IEntidadService extends IGenericService<Entidad, Long> {
	
	PaginateDTO filtrados(FilterDTO filtros) throws ServiceEJBException;

}
