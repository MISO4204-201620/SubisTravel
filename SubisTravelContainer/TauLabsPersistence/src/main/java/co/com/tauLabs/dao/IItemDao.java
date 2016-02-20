package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.model.Item;

public interface IItemDao extends IGenericDao<Entidad, Long> {
	
	List<Item> filtrados(FilterDTO filtros) throws PersistenceEJBException;
	
}
