package co.com.tauLabs.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import co.com.tauLabs.model.Entidad;

public interface IEntidadDao extends IGenericDao<Entidad, Long> {

	void nombreMeotod(Long id) throws PersistenceException;
	
	List<Entidad> obtenerEntidadesPorTipo(Long idTipo) throws PersistenceException;
}
