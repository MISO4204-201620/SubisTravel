package co.com.tauLabs.dao;

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.model.Item;

public interface IItemDao extends IGenericDao<Entidad, Long> {
	
	PaginateDTO filtrados(FilterDTO filtros) throws PersistenceEJBException;
	Item obtenerItemPorId(Long id) throws PersistenceEJBException;
	Boolean permiteCalificarItemPorUsuario(Long id,Long idUsuario) throws PersistenceEJBException;
	
}
