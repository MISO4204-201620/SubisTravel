package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.dto.ShoppingItem;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Transaccion;

public interface ITransaccionDao extends IGenericDao<Transaccion, Long> {
	
	Transaccion agregarItemACarrito(ShoppingItem item)throws PersistenceEJBException;

	void eliminarItemDeCarrito(Long idTransaccion)throws PersistenceEJBException;
	
	List<Transaccion> enCarritoPorEntidad(Long idEntidad) throws PersistenceEJBException;
	
	void realizarCompra(List<Long> idsTransaferencia) throws PersistenceEJBException;
}
