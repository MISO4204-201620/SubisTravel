package co.com.tauLabs.service.impl;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IItemDao;
import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.exception.ValidationException;
import co.com.tauLabs.model.Item;
import co.com.tauLabs.service.IItemService;

@Stateless
@Named
public class ItemService implements IItemService,Serializable {

	final static Logger logger = Logger.getLogger(ItemService.class);

	private static final long serialVersionUID = 1L;

	@Inject private IItemDao itemDao;

	public ItemService() {
		
    }
	
	@Override
	public PaginateDTO filtrados(FilterDTO filtros) throws ServiceEJBException {
		logger.debug("CS iniciando metodo filtrados()");
		try{
			if(filtros==null)throw new ValidationException("El filtro ingresado es nulo");
			return itemDao.filtrados(filtros);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando items por filtros, causa: "+e.getMessage());
		}
		
	}

	@Override
	public Item obtenerItemPorId(Long id) throws ServiceEJBException {
		logger.debug("CS iniciando metodo obtenerItemPorId()");
		try{
			if(id==null) throw new Exception("El ID ingresado es nulo");
			return itemDao.obtenerItemPorId(id);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando Item por id, causa: "+e.getMessage());
		}
	}
	
	@Override
	public Boolean permiteCalificarItemPorUsuario(Long id, Long idUsuario) throws ServiceEJBException {
		logger.debug("CS iniciando metodo obtenerItemPorId()");
		try{
			if(idUsuario==null) throw new Exception("El ID ingresado es nulo");
			return itemDao.permiteCalificarItemPorUsuario(id, idUsuario);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido validando si permite calificar un item por idUsuario, causa: "+e.getMessage());
		}
	}
}
