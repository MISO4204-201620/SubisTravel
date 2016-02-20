package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.IEntidadDao;
import co.com.tauLabs.model.Contenido;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.model.Item;

@Stateless
@Named
public class EntidadDao extends GenericDao<Entidad, Long>  implements IEntidadDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public EntidadDao() {

    }
    
    @Override
    public void nombreMeotod(Long id)throws PersistenceException{
    	try{
    	
    		if(id==null)throw new Exception("El identificador es nulo");
    	
    	}catch(Exception e){
    		throw new PersistenceException("CP Error ejecutnao el metodo tal,causa: "+e.getMessage());
    	}
    }

	@Override
	public List<Entidad> obtenerEntidadesPorTipo(Long idTipo) throws PersistenceException {
		logger.debug("CP iniciando metodo obtenerEntidadesPorTipo()");
		try{
	    	
    		if(idTipo==null)throw new Exception("El identificador es nulo");
    		
    		//String HQL = "SELECT e FROM Entidad e WHERE e.id_tipo=:tipo ";
    		TypedQuery<Entidad> namedQuery = this.em.createNamedQuery(QueryName.ENTIDADES_BY_TIPO.getValue(), Entidad.class);
    		namedQuery.setParameter("idTipo",idTipo);
    		return namedQuery.getResultList();
    		
    	}catch(Exception e){
    		logger.error("CP Erro consultando Entidades por tipo, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo obtenerEntidadesPorTipo,causa: "+e.getMessage());
    	}
		
	}
    
    
    
}
