package co.com.tauLabs.dao.impl;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import co.com.tauLabs.dao.IQualificationDao;
import co.com.tauLabs.model.Calificacion;




@Stateless
@Named
public class QualificationDao extends GenericDao<Calificacion, Long> implements IQualificationDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public QualificationDao() {
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

}
