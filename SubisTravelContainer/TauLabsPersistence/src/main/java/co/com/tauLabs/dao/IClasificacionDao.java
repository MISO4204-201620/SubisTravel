package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.model.Clasificacion;

public interface IClasificacionDao extends IGenericDao<Clasificacion, Long> {
	
	 List<Clasificacion> listar() throws Exception;
	
}
