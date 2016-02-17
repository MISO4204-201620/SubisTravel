package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import co.com.tauLabs.dao.IItemDao;
import co.com.tauLabs.dto.FiltroDTO;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.model.Item;

@Stateless
@Named
public class ItemDao extends GenericDao<Entidad, Long>  implements IItemDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public ItemDao() {

    }

	@Override
	public List<Item> filtrados(FiltroDTO filtros) throws Exception {
		logger.debug("CP iniciando metodo filtrados()");
		try{
			String HQL = "SELECT i FROM Item i ";
			String ands = "";
			String joins = "";
			
			if(filtros.getProviders()!=null){
				ands = ands+"WHERE ";
				joins = 
						"JOIN i.entidad e ";
				ands = 
						ands + "e.id IN :providers ";
			}
			
			if(filtros.getClasifications()!=null){
				if(ands.equals("")){
					ands = ands+"WHERE ";
				}else{
					ands = 
							ands + "AND c.id IN :clasifications ";
				}
				joins = 
						joins + "JOIN i.clasificacion c ";
				
			}

			if(filtros.getMinValue()!=null){
				if(ands.equals("")){
					ands = ands+"WHERE ";
					ands = 
							ands + "i.valor >= :minValue ";
				}else{
					ands = 
							ands + "AND i.valor >= :minValue ";
				}
				
			}
			if(filtros.getMaxValue()!=null){
				if(ands.equals("")){
					ands = ands+"WHERE ";
					ands = 
							ands + "i.valor <= :maxValue ";
				}else{
					ands = 
							ands + "AND i.valor <= :maxValue ";
				}
			}
			
			HQL = HQL + joins + ands;
			int paginaActual = filtros.getPage()!=null ? Integer.valueOf(filtros.getPage()) : 1;
			int inicial = 1*paginaActual;
			int ultimo = 10*paginaActual;
			
			TypedQuery<Item> namedQuery = this.em.createQuery(HQL, Item.class);
			namedQuery.setFirstResult(inicial);
			namedQuery.setMaxResults(ultimo);

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
			logger.error("CP Erro consultando items por filtros, causa: "+e.getMessage());
			throw new Exception("CP Erro consultando items por filtros, causa: "+e.getMessage());
		}
	}
    

    
}
