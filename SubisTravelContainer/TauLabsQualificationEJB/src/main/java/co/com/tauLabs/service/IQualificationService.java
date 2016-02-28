package co.com.tauLabs.service;

import javax.ejb.Local;

import co.com.tauLabs.model.Calificacion;
@Local
public interface IQualificationService {

	Calificacion agregarCalificacion(Calificacion calificacion)  throws Exception;
}
