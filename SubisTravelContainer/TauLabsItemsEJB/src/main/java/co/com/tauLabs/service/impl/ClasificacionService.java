package co.com.tauLabs.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IClasificacionDao;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Clasificacion;
import co.com.tauLabs.service.IClasificacionService;

@Stateless
@Named
public class ClasificacionService implements IClasificacionService,Serializable {

	final static Logger logger = Logger.getLogger(ClasificacionService.class);

	private static final long serialVersionUID = 1L;

	@EJB private IClasificacionDao clasificacionDao;

	public ClasificacionService() {
		
    }

	@Override
	public List<Clasificacion> listar() throws ServiceEJBException {
		logger.debug("CS iniciando metodo listar()");
		try{
			return clasificacionDao.listar();
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando las clasificaciones, causa: "+e.getMessage());
		}
	}

	@Override
	public Clasificacion guardar(Clasificacion clasificacion) throws ServiceEJBException {
		logger.debug("CS iniciando servicio guardar");
		try{
			clasificacion = clasificacionDao.guardar(clasificacion);
			return clasificacion;
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al guardar la clasificacion, causa: "+e.getMessage());
		}
	}

	@Override
	public Clasificacion modificar(Clasificacion clasificacion) throws ServiceEJBException {
		logger.debug("CS iniciando servicio modificar");
		try{
			clasificacionDao.modificar(clasificacion);
			return clasificacion;
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al modificar la clasificacion, causa: "+e.getMessage());
		}
	}

	@Override
	public Clasificacion obtenerPorId(Long idClasificacion) throws ServiceEJBException {
		logger.debug("CS iniciando servicio obtenerPorId");
		try{
			return clasificacionDao.obtenerPorId(idClasificacion);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al consultar una clasificación por su id, causa: "+e.getMessage());
		}
	}

	@Override
	public void eliminar(Long idClasificacion) throws ServiceEJBException {
		logger.debug("CS iniciando servicio eliminar");
		try{
			Clasificacion clasificacion = clasificacionDao.obtenerPorId(idClasificacion);
			clasificacionDao.eliminar(clasificacion);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al eliminar la clasificación, causa: "+e.getMessage());
		}
		
	}
	

	
}
