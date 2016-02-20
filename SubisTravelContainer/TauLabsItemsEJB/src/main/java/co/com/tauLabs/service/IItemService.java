package co.com.tauLabs.service;

import java.util.List;

import javax.ejb.Local;

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Item;

@Local
public interface IItemService {
	
	/**
	 * @author ServioAndres
	 * @return Lista de items filtrados por los criterior ingresados en filtros
	 */
	List<Item> filtrados(FilterDTO filtros) throws ServiceEJBException;

}
