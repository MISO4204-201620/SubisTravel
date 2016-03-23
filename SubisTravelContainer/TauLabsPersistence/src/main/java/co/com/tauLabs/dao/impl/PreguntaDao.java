package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.IPreguntaDao;
import co.com.tauLabs.model.Pregunta;

@Stateless
public class PreguntaDao extends GenericDao<Pregunta, Long>  implements IPreguntaDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public PreguntaDao() {

    }

    @Override
	public List<Pregunta> obtenerPreguntasPorItem(Long idItem) throws Exception {
		logger.debug("CP iniciando metodo obtenerPreguntasPorItem()");
		try{
    		if(idItem==null)throw new Exception("El identificador es nulo");
    		TypedQuery<Pregunta> namedQuery = this.em.createNamedQuery(QueryName.PREGUNTAS_BY_ITEM.getValue(), Pregunta.class);
    		namedQuery.setParameter("idItem",idItem);
    		return namedQuery.getResultList();
    		
    	}catch(Exception e){
    		logger.error("CP Erro consultando Preguntas por Item, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo obtenerCalificacionesPorItem,causa: "+e.getMessage());
    	}
	}

	@Override
	public List<Pregunta> obtenerPreguntasPorCatalogo(Long idCatalogo) throws Exception {
		logger.debug("CP iniciando metodo obtenerPreguntasPorCatalogo()");
		try{
    		if(idCatalogo==null)throw new Exception("El identificador es nulo");
    		TypedQuery<Pregunta> namedQuery = this.em.createNamedQuery(QueryName.PREGUNTAS_BY_CATALOG.getValue(), Pregunta.class);
    		namedQuery.setParameter("idCatalogo",idCatalogo);
    		return namedQuery.getResultList();
    		
    	}catch(Exception e){
    		logger.error("CP Erro consultando Preguntas por Catalogo, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo obtenerCalificacionesPorCatalogo,causa: "+e.getMessage());
    	}
	}
}
