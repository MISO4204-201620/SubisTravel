package co.com.tauLabs.dao;

import javax.persistence.PersistenceException;

import co.com.tauLabs.model.Entidad;

public interface IEntidadDao extends IGenericDao<Entidad, Long> {

	void nombreMeotod(Long id) throws PersistenceException;
	
}
