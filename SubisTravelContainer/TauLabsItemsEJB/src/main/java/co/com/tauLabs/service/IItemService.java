package co.com.tauLabs.service;

import javax.ejb.Local;

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Item;

@Local
public interface IItemService {
	
	/**
	 * @author ServioAndres
	 * @return Lista de items filtrados por los criterior ingresados en filtros
	 */
	PaginateDTO filtrados(FilterDTO filtros) throws ServiceEJBException;

	Item obtenerItemPorId(Long id) throws ServiceEJBException;
}
