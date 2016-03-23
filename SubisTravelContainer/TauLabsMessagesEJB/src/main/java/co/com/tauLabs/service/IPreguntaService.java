package co.com.tauLabs.service;

import java.util.List;

import javax.ejb.Local;

import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Pregunta;

@Local
public interface IPreguntaService {

	Pregunta registrarPregunta(Pregunta pregunta) throws ServiceEJBException;
	
	List<Pregunta> obtenerPreguntasPorItem(Long idItem) throws Exception;
	
	List<Pregunta> obtenerPreguntasPorCatalogo(Long idCatalogo) throws Exception;
}
