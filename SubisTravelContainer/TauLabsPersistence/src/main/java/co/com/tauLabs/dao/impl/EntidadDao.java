package co.com.tauLabs.dao.impl;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import co.com.tauLabs.dao.IEntidadDao;
import co.com.tauLabs.model.Entidad;

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
    
}
