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
	
}
