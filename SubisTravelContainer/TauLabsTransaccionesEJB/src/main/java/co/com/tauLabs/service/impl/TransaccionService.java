package co.com.tauLabs.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.ITransaccionDao;
import co.com.tauLabs.dto.ShoppingItem;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Transaccion;
import co.com.tauLabs.service.ITransaccionService;

@Stateless
@Named
public class TransaccionService implements ITransaccionService {

	@Inject private ITransaccionDao transaccionDao;

	final static Logger logger = Logger.getLogger(TransaccionService.class);
	
	@Override
	public Transaccion agregarItemACarrito(ShoppingItem item)throws ServiceEJBException{
		try{
			return transaccionDao.agregarItemACarrito(item);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al agregar el item al carrito de compras, causa: "+e.getMessage());
		}
	}

	@Override
	public void eliminarDeCarrito(Long idTransaccion) throws ServiceEJBException {
		try{
			transaccionDao.eliminarItemDeCarrito(idTransaccion);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al eliminar el item del carrito de compras, causa: "+e.getMessage());
		}
	}

	@Override
	public List<Transaccion> enCarritoPorEntidad(Long idEntidad) throws ServiceEJBException {
		try{
			List<Transaccion> transacciones =  transaccionDao.enCarritoPorEntidad(idEntidad);
			return transacciones;
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al consultar los items de un carrito de compras, causa: "+e.getMessage());
		}
	}

	@Override
	public void realizarCompra(List<Long> idsTransaferencia) throws ServiceEJBException {
		try{
			transaccionDao.realizarCompra(idsTransaferencia);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al consultar los items de un carrito de compras, causa: "+e.getMessage());
		}
	}

	@Override
	public List<Transaccion> getAllTransactions( ) throws ServiceEJBException {
	
		try{
			List<Transaccion> transacciones =  transaccionDao.getAllTransaction();
			return transacciones;
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al consultar los items de un carrito de compras, causa: "+e.getMessage());
		}
	
	}

	@Override
	public List<Transaccion> obtenerCompras(Long idUsuario) throws ServiceEJBException {
		try{
			if(idUsuario==null) throw new Exception("El identificador de la entidad es nulu");
			return transaccionDao.obtenerCompras(idUsuario);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al las compras de una entidad, causa: "+e.getMessage());
		}
	}

	@Override
	public List<Transaccion> obtenerVentas(Long idEntidad) throws ServiceEJBException {
		try{
			if(idEntidad==null) throw new Exception("El identificador de la entidad es nulu");
			return transaccionDao.obtenerVentas(idEntidad);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al consultar las ventas de una entidad, causa: "+e.getMessage());
		}
	}
	
	@Override
	public Long cantidadEnCarritoPorEntidad(Long idEntidad) throws ServiceEJBException {
		try{
			if(idEntidad==null) throw new Exception("El identificador de la entidad es null");
			return transaccionDao.cantidadEnCarritoPorEntidad(idEntidad);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al consultar los items de un carrito de compras, causa: "+e.getMessage());
		}
	}

}
