package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.ICalificacionDao;
import co.com.tauLabs.model.Calificacion;




@Stateless
@Named
public class CalificacionDao extends GenericDao<Calificacion, Long> implements ICalificacionDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public CalificacionDao() {
    }
    @PersistenceContext(unitName = "TauLabsEntidadesEJB")
	EntityManager em;

	@Override
	public Calificacion guardarCalificacion(Calificacion calificacion) throws Exception {
		logger.debug("CP iniciando metodo guardarCalificacion()");
		try{
	    	
    		if(calificacion==null)throw new Exception("El objeto calificacion es nulo");
    		em.persist(calificacion);
    		return calificacion;
    	}catch(Exception e){
    		logger.error("CP Error guardando la calificacion, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo guardarCalificacion,causa: "+e.getMessage());
    	}
	}

	@Override
	public List<Calificacion> obtenerCalificacionesPorItem(Long idItem) throws Exception {
		logger.debug("CP iniciando metodo obtenerCalificacionesPorItem()");
		try{
    		if(idItem==null)throw new Exception("El identificador es nulo");
    		TypedQuery<Calificacion> namedQuery = this.em.createNamedQuery(QueryName.CALIFICACIONES_BY_ITEM.getValue(), Calificacion.class);
    		namedQuery.setParameter("idItem",idItem);
    		return namedQuery.getResultList();
    		
    	}catch(Exception e){
    		logger.error("CP Erro consultando Entidades por tipo, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo obtenerCalificacionesPorItem,causa: "+e.getMessage());
    	}
	}

	@Override
	public List<Calificacion> obtenerCalificacionesPorCatalogo(Long idCatalogo) throws Exception {
		logger.debug("CP iniciando metodo obtenerCalificacionesPorCatalogo()");
		try{
    		if(idCatalogo==null)throw new Exception("El identificador es nulo");
    		TypedQuery<Calificacion> namedQuery = this.em.createNamedQuery(QueryName.CALIFICACIONES_BY_CATALOG.getValue(), Calificacion.class);
    		namedQuery.setParameter("idCatalogo",idCatalogo);
    		return namedQuery.getResultList();
    		
    	}catch(Exception e){
    		logger.error("CP Erro consultando Entidades por tipo, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo obtenerCalificacionesPorCatalogo,causa: "+e.getMessage());
    	}
	}

}
