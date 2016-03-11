package co.com.tauLabs.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.ICalificacionDao;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Calificacion;
import co.com.tauLabs.service.ICalificacionService;
import co.com.tauLabs.service.rest.CalificacionServiceRS;

@Stateless
@Named
public class CalificacionService implements ICalificacionService {

	@Inject private ICalificacionDao calificacionDao;

	final static Logger logger = Logger.getLogger(CalificacionServiceRS.class);
	
	@Override
	public Calificacion agregarCalificacion(Calificacion calificacion) throws Exception {
		logger.debug("CS iniciando metodo agregarCalificacion()");
		try{
			if(calificacion==null) throw new Exception("el objeto de calificacion es nulo");
			return calificacionDao.guardarCalificacion(calificacion);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error guardando la calificacion, causa: "+e.getMessage());
		}
	}

	@Override
	public List<Calificacion> obtenerCalificacionesPorItem(Long idItem) throws Exception {
		logger.debug("CS iniciando metodo obtenerCalificacionesPorItem()");
		try{
			if(idItem==null) throw new Exception("el id del item es nulo");
			return calificacionDao.obtenerCalificacionesPorItem(idItem);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error obteniendo el listado de calificaciones por Item, causa: "+e.getMessage());
		}
	}
	
	@Override
	public List<Calificacion> obtenerCalificacionesPorCatalogo(Long idCatalogo) throws Exception {
		logger.debug("CS iniciando metodo obtenerCalificacionesPorItem()");
		try{
			if(idCatalogo==null) throw new Exception("el id del item es nulo");
			return calificacionDao.obtenerCalificacionesPorCatalogo(idCatalogo);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error obteniendo el listado de calificaciones por Item, causa: "+e.getMessage());
		}
	}
}
