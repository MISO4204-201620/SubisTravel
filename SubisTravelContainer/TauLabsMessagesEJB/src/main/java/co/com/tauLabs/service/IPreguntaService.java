package co.com.tauLabs.service;

import javax.ejb.Local;

import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Pregunta;

@Local
public interface IPreguntaService {

	Pregunta registrarPregunta(Pregunta pregunta) throws ServiceEJBException;
}
