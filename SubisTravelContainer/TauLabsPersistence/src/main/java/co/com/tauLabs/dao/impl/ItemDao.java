package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.tauLabs.dao.IItemDao;
import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ValidationException;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.model.Item;

@Stateless
@Named
public class ItemDao extends GenericDao<Entidad, Long>  implements IItemDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public ItemDao() {

    }
    @PersistenceContext(unitName = "TauLabsEntidadesEJB")
	EntityManager em;
    
	@Override
	public List<Item> filtrados(FilterDTO filtros) throws PersistenceEJBException {
		logger.debug("CP iniciando metodo filtrados()");
		try{
			if(filtros==null)throw new ValidationException("El filtro ingresado es nulo");
			String HQL = "SELECT i FROM Item i ";
			String ands = "";
			String joins = "";

			if(filtros.getName()!=null && !filtros.getName().trim().equals("")){
				ands = ands+"WHERE ";
				ands = ands + "i.nombre like (:nombre) ";
			}
			
			if(filtros.getProviders()!=null){
				if(ands.equals("")){
					ands = ands+"WHERE ";
					ands = ands + "e.id IN :providers ";
				}else{
					ands = ands + "AND e.id IN :providers ";
				}
				joins = "JOIN i.entidad e ";
			}
			
			if(filtros.getClasifications()!=null){
				if(ands.equals("")){
					ands = ands+"WHERE ";
					ands = ands + "c.id IN :clasifications ";
				}else{
					ands = ands + "AND c.id IN :clasifications ";
				}
				joins = joins + "JOIN i.clasificacion c ";
				
			}

			if(filtros.getMinValue()!=null){
				if(ands.equals("")){
					ands = ands+"WHERE ";
					ands = ands + "i.valor >= :minValue ";
				}else{
					ands = ands + "AND i.valor >= :minValue ";
				}
				
			}
			if(filtros.getMaxValue()!=null){
				if(ands.equals("")){
					ands = ands+"WHERE ";
					ands = ands + "i.valor <= :maxValue ";
				}else{
					ands = ands + "AND i.valor <= :maxValue ";
				}
			}
		
			HQL = HQL + joins + ands;
			int paginaActual = filtros.getPage()!=null ? Integer.valueOf(filtros.getPage()) : 1;
			int inicial = 1*paginaActual;
			int ultimo = 10*paginaActual;
			
			TypedQuery<Item> namedQuery = this.em.createQuery(HQL, Item.class);
			namedQuery.setFirstResult(inicial);
			namedQuery.setMaxResults(ultimo);

			if(filtros.getName()!=null && !filtros.getName().trim().equals("")){
				namedQuery.setParameter("nombre","%"+filtros.getName()+"%");
			}
				
			if(filtros.getProviders()!=null){
				namedQuery.setParameter("providers",filtros.getProviders());
			}
			if(filtros.getClasifications()!=null){
				namedQuery.setParameter("clasifications",filtros.getClasifications());
			}
			if(filtros.getMinValue()!=null){
				namedQuery.setParameter("minValue",filtros.getMinValue());

			}
			if(filtros.getMaxValue()!=null){
				namedQuery.setParameter("maxValue",filtros.getMaxValue());
			}
			
			return namedQuery.getResultList();
		}catch(Exception e){
			throw new PersistenceEJBException("CP Error consultando items por filtros, causa: "+e.getMessage());
		}
	}
    
	@Override
	public Item obtenerItemPorId(Long id) throws PersistenceEJBException {
		logger.debug("CP iniciando metodo obtenerEntidadesPorTipo()");
		try{
	    	
    		if(id==null)throw new Exception("El identificador es nulo");
    		return (Item) em.find(Item.class,id);
    	}catch(Exception e){
    		logger.error("CP Erro consultando Entidades por tipo, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo obtenerEntidadesPorTipo,causa: "+e.getMessage());
    	}
		
	}
    
}
