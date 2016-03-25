package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.IItemDao;
import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.enums.TransaccionEstadoEnum;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ValidationException;
import co.com.tauLabs.model.Item;
import co.com.tauLabs.model.Pregunta;

@Stateless
@Named
public class ItemDao extends GenericDao<Item, Long>  implements IItemDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public ItemDao() {

    }
    @PersistenceContext(unitName = "TauLabsEntidadesEJB")
	EntityManager em;
    
	@Override
	public PaginateDTO filtrados(FilterDTO filtros) throws PersistenceEJBException {
		logger.debug("CP iniciando metodo filtrados()");
		try{
			if(filtros==null)throw new ValidationException("El filtro ingresado es nulo");
			String HQL = "SELECT DISTINCT i FROM Item i ";
			String HQLCount = "SELECT COUNT(DISTINCT i.id) FROM Item i ";
			String ands = "";
			String joins = "";
			PaginateDTO paginate = new PaginateDTO();

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

			if(filtros.getTypes()!=null){
				if(ands.equals("")){
					ands = ands+"WHERE ";
					ands = ands + "i.idTipo IN :types ";
				}else{
					ands = ands + "AND i.idTipo IN :types ";
				}
				
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
			HQLCount = HQLCount + joins + ands;
			int paginaActual = filtros.getPage()!=null ? Integer.valueOf(filtros.getPage()) : 1;
			int	inicial = (10*paginaActual)-10;

			TypedQuery<Item> namedQuery = this.em.createQuery(HQL, Item.class);
			TypedQuery<Long> namedQueryCount = this.em.createQuery(HQLCount, Long.class);

			if(filtros.getTypes()!=null){
				namedQuery.setParameter("types",filtros.getTypes());
				namedQueryCount.setParameter("types",filtros.getTypes());
			}
			
			if(filtros.getName()!=null && !filtros.getName().trim().equals("")){
				namedQuery.setParameter("nombre","%"+filtros.getName()+"%");
				namedQueryCount.setParameter("nombre","%"+filtros.getName()+"%");
			}
				
			if(filtros.getProviders()!=null){
				namedQuery.setParameter("providers",filtros.getProviders());
				namedQueryCount.setParameter("providers",filtros.getProviders());
			}
			
			if(filtros.getClasifications()!=null){
				namedQuery.setParameter("clasifications",filtros.getClasifications());
				namedQueryCount.setParameter("clasifications",filtros.getClasifications());
			}
			
			if(filtros.getMinValue()!=null){
				namedQuery.setParameter("minValue",filtros.getMinValue());
				namedQueryCount.setParameter("minValue",filtros.getMinValue());

			}
			if(filtros.getMaxValue()!=null){
				namedQuery.setParameter("maxValue",filtros.getMaxValue());
				namedQueryCount.setParameter("maxValue",filtros.getMaxValue());
			}
			
			//Cantidad de registros
			Long cantidadRegistros = namedQueryCount.getSingleResult();
			paginate.setElements(cantidadRegistros);
			
			//Cantidad de paginas
			Long paginas = (long)Math.ceil(cantidadRegistros/10D);
			paginate.setPages(paginas);		
			
			namedQuery.setFirstResult(inicial);
			namedQuery.setMaxResults(10);
			
			List<Item> items = namedQuery.getResultList();
			paginate.setLstElements(new ArrayList<Object>());
			
			if(items.size()>0){
				for (Item item : items) {
					paginate.getLstElements().add(item);
				}
			}
			
			return paginate;
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
    
	@Override
	public Boolean permiteCalificarItemPorUsuario(Long id, Long idUsuario) throws PersistenceEJBException {
		logger.debug("CP iniciando metodo permiteCalificarItemPorUsuario()");
		try{
    		if(idUsuario==null)throw new Exception("El identificador es nulo");
    		TypedQuery<Pregunta> namedQuery = this.em.createNamedQuery(QueryName.TRANSACCIONES_BY_ITEM_BY_USER_BY_STATE.getValue(), Pregunta.class);
    		namedQuery.setParameter("idItem",id);
    		namedQuery.setParameter("idUsuario",idUsuario);
    		namedQuery.setParameter("estado",TransaccionEstadoEnum.COMPLETADA.getValue());
    		return namedQuery.getResultList().size()>0?true:false;
    	}catch(Exception e){
    		logger.error("CP Error consultando Transacciones por usuario por estado, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo permiteCalificarItemPorUsuario,causa: "+e.getMessage());
    	}
	}
}
