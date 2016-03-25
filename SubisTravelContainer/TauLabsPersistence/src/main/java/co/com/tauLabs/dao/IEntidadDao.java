package co.com.tauLabs.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Entidad;

public interface IEntidadDao extends IGenericDao<Entidad, Long> {

	
	/**
	 * @author ServioAndres
	 * @return Lista de entidades que aplican los determinados filtros
	 */
	public PaginateDTO filtrados(FilterDTO filtros) throws PersistenceEJBException;
	
	List<Entidad> obtenerEntidadesPorEstado(String estado) throws PersistenceException;
}
