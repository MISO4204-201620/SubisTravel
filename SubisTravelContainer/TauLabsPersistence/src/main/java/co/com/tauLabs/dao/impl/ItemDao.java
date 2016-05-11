package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.IBusquedaDao;
import co.com.tauLabs.dao.IConsultaDao;
import co.com.tauLabs.dao.IItemDao;
import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.dto.ReportBusquedaDTO;
import co.com.tauLabs.dto.ReportConsultaDTO;
import co.com.tauLabs.enums.ConsultaTipoEnum;
import co.com.tauLabs.enums.TransaccionEstadoEnum;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ValidationException;
import co.com.tauLabs.model.Busqueda;
import co.com.tauLabs.model.Consulta;
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
    
    @Inject
	private IBusquedaDao iBusquedaDao;
    
    @Inject
	private IConsultaDao iConsultaDao;
    
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
			String textoBusqueda = "";
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
			
			if(filtros.getEstado()!=null){
				if(ands.equals("")){
					ands = ands+"WHERE ";
					ands = ands + "i.estado = :estado ";
				}else{
					ands = ands + "AND i.estado = :estado ";
				}
			}

			HQL = HQL + joins + ands;
			HQLCount = HQLCount + joins + ands;
			int paginaActual = filtros.getPage()!=null ? Integer.valueOf(filtros.getPage()) : 1;
			int	inicial = (12*paginaActual)-12;

			TypedQuery<Item> namedQuery = this.em.createQuery(HQL, Item.class);
			TypedQuery<Long> namedQueryCount = this.em.createQuery(HQLCount, Long.class);

			if(filtros.getTypes()!=null){
				namedQuery.setParameter("types",filtros.getTypes());
				namedQueryCount.setParameter("types",filtros.getTypes());
			}
			
			if(filtros.getName()!=null && !filtros.getName().trim().equals("")){
				namedQuery.setParameter("nombre","%"+filtros.getName()+"%");
				namedQueryCount.setParameter("nombre","%"+filtros.getName()+"%");
				textoBusqueda=filtros.getName();
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
			if(filtros.getEstado()!=null){
				namedQuery.setParameter("estado",filtros.getEstado());
				namedQueryCount.setParameter("estado",filtros.getEstado());
			}
			
			//Cantidad de registros
			Long cantidadRegistros = namedQueryCount.getSingleResult();
			paginate.setElements(cantidadRegistros);
			
			//Cantidad de paginas
			Long paginas = (long)Math.ceil(cantidadRegistros/12D);
			paginate.setPages(paginas);		
			
			namedQuery.setFirstResult(inicial);
			namedQuery.setMaxResults(12);
			
			List<Item> items = namedQuery.getResultList();
			paginate.setLstElements(new ArrayList<Object>());
			
			if(items.size()>0){
				//Se crea registro en busqueda!
				Busqueda busqueda = new Busqueda();
				if(textoBusqueda.trim().length()>0)
				{  
					busqueda.setFecha(new Date());
					busqueda.setTexto(textoBusqueda);
					busqueda = iBusquedaDao.guardar(busqueda);
				}
				for (Item item : items) {
					paginate.getLstElements().add(item);
					if(textoBusqueda.trim().length()>0 && busqueda.getId()!=null)
					{
						processAsyncRegistroConsulta(item,busqueda,ConsultaTipoEnum.BUSQUEDA.getValue());
					}
				}
			}
			
			return paginate;
		}catch(Exception e){
			throw new PersistenceEJBException("CP Error consultando items por filtros, causa: "+e.getMessage());
		}
	}
    
	@Override
	public Item obtenerItemPorId(Long id) throws PersistenceEJBException {
		logger.debug("CP iniciando metodo obtenerItemPorId()");
		try{
	    	
    		if(id==null)throw new Exception("El identificador es nulo");
    		Item item= em.find(Item.class,id);
    		if(item !=null){
    			processAsyncRegistroConsulta(item,null,ConsultaTipoEnum.CONSULTA.getValue());
    		}
    		return item;
    	}catch(Exception e){
    		logger.error("CP Erro consultando Item por id, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutando el metodo obtenerItemPorId,causa: "+e.getMessage());
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
	
	@Asynchronous
	public void  processAsyncRegistroConsulta(Item item, Busqueda busqueda, String tipo) throws Exception {
		try {
			 new Thread(() -> this.registroConsulta(item,busqueda,tipo)).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean  registroConsulta(Item item, Busqueda busqueda, String tipo) {
		try {
			logger.info("Ingresando metodo asyncrono registro processRegistroConsulta");
			Consulta consulta = new Consulta();
			consulta.setFecha(new Date());
			consulta.setIdItem(item.getId());
			if(busqueda!=null && busqueda.getId()!=null){
				consulta.setIdBusqueda(busqueda.getId());
			}
			consulta.setTipoConsulta(tipo);
			consulta = iConsultaDao.guardar(consulta);
		    return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ReportBusquedaDTO> reporteBusquedaItems(Long idUsuario) throws PersistenceEJBException {
		// TODO Auto-generated method stub
		logger.debug("CP iniciando metodo reporteBusquedaItems()");
		try{
    		if(idUsuario==null)throw new Exception("El identificador es nulo");
    		TypedQuery<Object> namedQuery = this.em.createNamedQuery(QueryName.REPORTE_ITEMS_BY_USER_CONSULTADOS_BY_TIPO.getValue(), Object.class);
    		namedQuery.setParameter("idUsuario",idUsuario);
    		namedQuery.setParameter("tipoConsulta",ConsultaTipoEnum.BUSQUEDA.getValue());
    		List<Object> resultList = namedQuery.getResultList();
    		List<ReportBusquedaDTO> lstReporte = new ArrayList<ReportBusquedaDTO>();
    		for (Object result : resultList) {
    		    Object[] r = (Object[]) result;
    		    ReportBusquedaDTO reporte = new ReportBusquedaDTO();
    		    reporte.setNombreItem(r[1].toString());
    		    reporte.setIdItem((Long)r[0]);
    		    reporte.setCantidad((Long)r[2]);
    		    //Recuperando las palabras buscadas!
    		    TypedQuery<Object> namedQuery1 = this.em.createNamedQuery(QueryName.REPORTE_TEXTO_BUSCADO_BY_ITEM.getValue(), Object.class);
    		    namedQuery1.setParameter("idItem",reporte.getIdItem());
        		List<Object> rslst = namedQuery1.getResultList();
        		String textoBuscado="";
        		for (Object text : rslst) {
        		    textoBuscado=textoBuscado+";"+text.toString();
        		}
        		reporte.setPalabrasBuscadas(textoBuscado);
        		//*********************
        		
    		    lstReporte.add(reporte);
    		}
    		return lstReporte;
    	}catch(Exception e){
    		logger.error("CP Error consultando reporteBusquedaItems, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo permiteCalificarItemPorUsuario,causa: "+e.getMessage());
    	}
	}

	@Override
	public List<ReportConsultaDTO> reporteConsultaItems(Long idUsuario) throws PersistenceEJBException {
		logger.debug("CP iniciando metodo permiteCalificarItemPorUsuario()");
		try{
    		if(idUsuario==null)throw new Exception("El identificador es nulo");
    		TypedQuery<Object> namedQuery = this.em.createNamedQuery(QueryName.REPORTE_ITEMS_BY_USER_CONSULTADOS_BY_TIPO.getValue(), Object.class);
    		namedQuery.setParameter("idUsuario",idUsuario);
    		namedQuery.setParameter("tipoConsulta",ConsultaTipoEnum.CONSULTA.getValue());
    		List<Object> resultList = namedQuery.getResultList();
    		List<ReportConsultaDTO> lstReporte = new ArrayList<ReportConsultaDTO>();
    		for (Object result : resultList) {
    		    Object[] r = (Object[]) result;
    		    ReportConsultaDTO reporte = new ReportConsultaDTO();
    		    reporte.setNombreItem(r[1].toString());
    		    reporte.setIdItem((Long)r[0]);
    		    reporte.setCantidad((Long)r[2]);
    		    lstReporte.add(reporte);
    		}
    		return lstReporte;
    		
    	}catch(Exception e){
    		logger.error("CP Error consultando Transacciones por usuario por estado, causa: "+e.getMessage());
    		throw new PersistenceException("CP Error ejecutnao el metodo permiteCalificarItemPorUsuario,causa: "+e.getMessage());
    	}
	}
	
}
