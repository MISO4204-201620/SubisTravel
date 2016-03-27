package co.com.tauLabs.service;

import java.util.List;

import javax.ejb.Local;

import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Clasificacion;

@Local
public interface IClasificacionService {
	
	/**
	 * @author ServioAndres
	 * @return List of contents by a defined item
	 */
	List<Clasificacion> listar() throws ServiceEJBException;
	
	Clasificacion guardar(Clasificacion clasificacion) throws ServiceEJBException;
	
	Clasificacion modificar(Clasificacion clasificacion) throws ServiceEJBException;
	
	Clasificacion obtenerPorId(Long idClasificacion) throws ServiceEJBException;
	
	void eliminar(Long idClasificacion) throws ServiceEJBException;

}
