package co.com.tauLabs.service;

import java.util.List;

import javax.ejb.Local;

import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Catalogo;
import co.com.tauLabs.model.Clasificacion;
import co.com.tauLabs.model.Contenido;

@Local
public interface ICatalogoService {
	
	/**
	 * @author ServioAndres
	 * @return List of contents by a defined item
	 */
	List<Catalogo> listar() throws ServiceEJBException;

}
