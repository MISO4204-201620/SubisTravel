package co.com.tauLabs.dao;

import co.com.tauLabs.model.Calificacion;
import co.com.tauLabs.model.Entidad;

public interface IQualificationDao extends IGenericDao<Calificacion, Long> {

	Calificacion guardarCalificacion(Calificacion calificacion) throws Exception;
}
