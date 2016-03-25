package co.com.tauLabs.service;

import java.util.List;

import javax.ejb.Local;

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Entidad;

@Local
public interface IEntidadService extends IGenericService<Entidad, Long> {
	
	PaginateDTO filtrados(FilterDTO filtros) throws ServiceEJBException;
	
	List<Entidad> obtenerEntidadesPorTipo(Long idTipo) throws Exception;

	List<Entidad> solicitudesBaja() throws ServiceEJBException;
	
	Entidad solicitarBaja(Long id) throws ServiceEJBException;
	
	Entidad darBaja(Long id) throws ServiceEJBException;
}
