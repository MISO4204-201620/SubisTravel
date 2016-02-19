package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Contenido;
import co.com.tauLabs.model.Entidad;

public interface IContenidoDao extends IGenericDao<Entidad, Long> {
	
	public List<Contenido> byItem(Long idItem) throws PersistenceEJBException;
	
}
