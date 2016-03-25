package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.IEntidadDao;
import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ValidationException;
import co.com.tauLabs.model.Entidad;

@Stateless
@Named
public class EntidadDao extends GenericDao<Entidad, Long>  implements IEntidadDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public EntidadDao() {

    }
    
	
	@Override
	public PaginateDTO filtrados(FilterDTO filtros) throws PersistenceEJBException {
		logger.debug("CP iniciando metodo filtrados()");
		try{
			if(filtros==null)throw new ValidationException("El filtro ingresado es nulo");
			String HQL = "SELECT e FROM Entidad e ";
			String HQLCount = "SELECT COUNT(e.id) FROM Entidad e ";
			String ands = "";
			String joins = "";
			PaginateDTO paginate = new PaginateDTO();
			
			ands = ands+"WHERE ";
			ands = ands + "e.idTipo = 4 ";
			joins = "JOIN e.tipo t ";
			
			if(filtros.getClasifications()!=null){
				if(ands.equals("")){
					ands = ands+"WHERE ";
					ands = ands + "c.id IN :clasifications ";
				}else{
					ands = ands + "AND c.id IN :clasifications ";
				}
				joins = joins + "JOIN e.items i JOIN i.clasificacion c ";
				
			}

			HQL = HQL + joins + ands;
			HQLCount = HQLCount + joins + ands;
			int paginaActual = filtros.getPage()!=null ? Integer.valueOf(filtros.getPage()) : 1;
			int	inicial = (10*paginaActual)-10;

			TypedQuery<Entidad> namedQuery = this.em.createQuery(HQL, Entidad.class);
			TypedQuery<Long> namedQueryCount = this.em.createQuery(HQLCount, Long.class);
				
			if(filtros.getClasifications()!=null){
				namedQuery.setParameter("clasifications",filtros.getClasifications());
				namedQueryCount.setParameter("clasifications",filtros.getClasifications());
			}
			
			//Cantidad de registros
			Long cantidadRegistros = namedQueryCount.getSingleResult();
			paginate.setElements(cantidadRegistros);
			
			//Cantidad de paginas
			Long paginas = (long)Math.ceil(cantidadRegistros/10D);
			paginate.setPages(paginas);		
			
			namedQuery.setFirstResult(inicial);
			namedQuery.setMaxResults(10);
			
			List<Entidad> entidades = namedQuery.getResultList();
			paginate.setLstElements(new ArrayList<Object>());
			
			if(entidades.size()>0){
				for (Entidad entidad : entidades) {
					paginate.getLstElements().add(entidad);
				}
			}
			
			return paginate;
		}catch(Exception e){
			throw new PersistenceEJBException("CP Error consultando entidades por filtros, causa: "+e.getMessage());
		}
	}
    
	@Override
	public List<Entidad> obtenerEntidadesPorEstado(String estado) throws PersistenceException  {
		logger.debug("CP iniciando metodo obtenerEntidadesPorEstado()");
		try{
	    	
    		if(estado==null)throw new Exception("El estado no es válido");
    		//String HQL = "SELECT e FROM Entidad e WHERE e.id_tipo=:tipo ";
    		TypedQuery<Entidad> namedQuery = this.em.createNamedQuery(QueryName.ENTIDADES_BY_ESTADO.getValue(), Entidad.class);
    		namedQuery.setParameter("estado",estado);
    		return namedQuery.getResultList();
    		
    	}catch(Exception e){
    		logger.error("CP Erro consultando Entidades por tipo, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo obtenerEntidadesPorEstado,causa: "+e.getMessage());
    	}
	}
}
