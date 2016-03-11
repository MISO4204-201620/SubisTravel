package co.com.tauLabs.service;

import java.util.List;

import javax.ejb.Local;

import co.com.tauLabs.model.Calificacion;
@Local
public interface ICalificacionService {

	Calificacion agregarCalificacion(Calificacion calificacion)  throws Exception;
	
	List<Calificacion> obtenerCalificacionesPorItem(Long idItem) throws Exception;
	
	List<Calificacion> obtenerCalificacionesPorCatalogo(Long idCatalogo) throws Exception;
}
