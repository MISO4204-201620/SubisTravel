package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.model.Calificacion;
import co.com.tauLabs.model.Entidad;

public interface IQualificationDao extends IGenericDao<Calificacion, Long> {

	Calificacion guardarCalificacion(Calificacion calificacion) throws Exception;
	
	List<Calificacion> obtenerCalificacionesPorItem(Long idItem) throws Exception;
	
	List<Calificacion> obtenerCalificacionesPorCatalogo(Long idCatalogo) throws Exception;
}
