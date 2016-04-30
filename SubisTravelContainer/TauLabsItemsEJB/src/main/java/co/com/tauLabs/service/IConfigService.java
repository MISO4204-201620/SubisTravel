package co.com.tauLabs.service;


import javax.ejb.Local;

import co.com.tauLabs.dto.ProductTypeDTO;
import co.com.tauLabs.exception.ServiceEJBException;


@Local
public interface IConfigService {
	
	/**
	 * @author ServioAndres
	 * @return List of contents by a defined item
	 */
	ProductTypeDTO getProperty(String key) throws ServiceEJBException;

}
