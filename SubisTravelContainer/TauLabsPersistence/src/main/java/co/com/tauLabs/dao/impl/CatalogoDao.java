package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.ICatalogoDao;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Catalogo;

@Stateless
public class CatalogoDao extends GenericDao<Catalogo, Long>  implements ICatalogoDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public CatalogoDao() {

    }

	@Override
	public List<Catalogo> listar() throws Exception {
		logger.debug("CP iniciando metodo listar()");
		try{
			TypedQuery<Catalogo> namedQuery = this.em.createNamedQuery(QueryName.CATALOGOS_ALL.getValue(), Catalogo.class);
			return namedQuery.getResultList();
		}catch(Exception e){
			throw new PersistenceEJBException("CP Error consultando catalogos, causa: "+e.getMessage());
		}
	}
    

    
}
