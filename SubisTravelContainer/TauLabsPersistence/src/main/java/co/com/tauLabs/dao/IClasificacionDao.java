package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Clasificacion;
import co.com.tauLabs.model.Contenido;
import co.com.tauLabs.model.Entidad;

public interface IClasificacionDao extends IGenericDao<Clasificacion, Long> {
	
	 List<Clasificacion> listar() throws Exception;
	
}
