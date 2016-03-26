package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.IClasificacionDao;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Clasificacion;

@Stateless
public class ClasificacionDao extends GenericDao<Clasificacion, Long>  implements IClasificacionDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public ClasificacionDao() {

    }

    @Override
	public List<Clasificacion> listar() throws Exception {
		logger.debug("CP iniciando metodo listar()");
		try{
			TypedQuery<Clasificacion> namedQuery = this.em.createNamedQuery(QueryName.CLASIFICACIONES_ALL.getValue(), Clasificacion.class);
			return namedQuery.getResultList();
		}catch(Exception e){
			throw new PersistenceEJBException("CP Error consultando clasificaciones, causa: "+e.getMessage());
		}
	}
    

    
}
