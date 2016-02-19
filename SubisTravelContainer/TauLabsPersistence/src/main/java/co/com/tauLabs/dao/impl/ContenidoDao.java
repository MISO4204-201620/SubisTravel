package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.IContenidoDao;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ValidationException;
import co.com.tauLabs.model.Contenido;
import co.com.tauLabs.model.Entidad;

@Stateless
public class ContenidoDao extends GenericDao<Entidad, Long>  implements IContenidoDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public ContenidoDao() {

    }

	@Override
	public List<Contenido> byItem(Long idItem) throws PersistenceEJBException {
		logger.debug("CP iniciando metodo porItem()");
		try{
			if(idItem==null) throw new ValidationException("El item ingresado es nulo");
			TypedQuery<Contenido> namedQuery = this.em.createNamedQuery(QueryName.CONTENIDO_BY_ITEM.getValue(), Contenido.class);
			namedQuery.setParameter("idItem", idItem);
			return namedQuery.getResultList();
		}catch(Exception e){
			throw new PersistenceEJBException("CP Error consultando contenidos de un item, causa: "+e.getMessage());
		}
	}
    

    
}
