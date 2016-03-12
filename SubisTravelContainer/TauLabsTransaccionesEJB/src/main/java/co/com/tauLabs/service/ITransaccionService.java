package co.com.tauLabs.service;

import java.util.List;

import javax.ejb.Local;

import co.com.tauLabs.dto.ShoppingItem;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Transaccion;
@Local
public interface ITransaccionService {

	Transaccion agregarItemACarrito(ShoppingItem item) throws ServiceEJBException;
	
	void eliminarDeCarrito(Long idTransaccion) throws ServiceEJBException;

	List<Transaccion> enCarritoPorEntidad(Long idEntidad) throws ServiceEJBException;
	
	void realizarCompra(List<Long> idsTransaferencia) throws ServiceEJBException;
	
}
