package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.dto.FiltroDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.model.Item;

public interface IItemDao extends IGenericDao<Entidad, Long> {
	
	List<Item> filtrados(FiltroDTO filtros) throws PersistenceEJBException;
	
}
