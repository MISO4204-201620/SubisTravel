package co.com.tauLabs.service.impl;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dto.ProductTypeDTO;
import co.com.tauLabs.enums.ServiciosActivosEnum;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.service.IConfigService;

@Stateless
@Named
public class ConfigService implements IConfigService,Serializable {

	final static Logger logger = Logger.getLogger(ConfigService.class);

	private static final long serialVersionUID = 1L;

	public ConfigService() {
		
    }

	@Override
	public ProductTypeDTO getProperty(String key) throws ServiceEJBException {
		logger.debug("CS iniciando metodo getProperty()");
		try{
			ProductTypeDTO retorno = new ProductTypeDTO();
			retorno.setProductType("Basic");
			if(ServiciosActivosEnum.BASIC.getValue()){
				retorno.setProductType("Basic");
			}
			else if(ServiciosActivosEnum.INTERMEDIATE.getValue()){
				retorno.setProductType("Intermediate");
			}
			else if(ServiciosActivosEnum.PRO.getValue()){
				retorno.setProductType("Pro");
			}
			
			return retorno;
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando getProperty, causa: "+e.getMessage());
		}
	}
	

	
}
