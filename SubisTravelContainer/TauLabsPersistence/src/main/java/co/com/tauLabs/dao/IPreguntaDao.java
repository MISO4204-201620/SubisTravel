package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.model.Pregunta;

public interface IPreguntaDao extends IGenericDao<Pregunta, Long> {

	List<Pregunta> obtenerPreguntasPorItem(Long idItem) throws Exception;
	
	List<Pregunta> obtenerPreguntasPorCatalogo(Long idCatalogo) throws Exception;
	
	List<Pregunta> obtenerPreguntasPorPreguntaPadre(Long idPreguntaPadre) throws Exception;
}
