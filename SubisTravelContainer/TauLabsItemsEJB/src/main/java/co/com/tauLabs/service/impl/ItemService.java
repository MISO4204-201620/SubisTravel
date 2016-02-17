package co.com.tauLabs.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IItemDao;
import co.com.tauLabs.dto.FiltroDTO;
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
	public List<Item> filtrados(FiltroDTO filtros) throws Exception {
		logger.debug("CS iniciando metodo filtrados()");
		try{
			if(filtros==null) throw new Exception("Los filtros ingresados son nulos");
			return itemDao.filtrados(filtros);
		}catch(Exception e){
			logger.error("CS Ha ocurrido un error consultando items por filtros, causa: "+e.getMessage());
			throw new Exception("CS Ha ocurrido un error consultando items por filtros, causa: "+e.getMessage());
		}
		
	}
	
}
