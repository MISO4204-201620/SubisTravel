package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import co.com.tauLabs.dao.ITransaccionDao;
import co.com.tauLabs.dto.ShoppingItem;
import co.com.tauLabs.enums.TransaccionEstadoEnum;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Item;
import co.com.tauLabs.model.Transaccion;

@Stateless
public class TransaccionDao extends GenericDao<Transaccion, Long> implements ITransaccionDao, Serializable {

	private static final long serialVersionUID = 554771308104758587L;

	public TransaccionDao() {

	}

	@Override
	public Transaccion agregarItemACarrito(ShoppingItem item) throws PersistenceEJBException {
		try {
			Transaccion transaccion = new Transaccion();
			transaccion.setEstado(TransaccionEstadoEnum.CARRITO.getValue());
			transaccion.setIdItem(item.getIdItem());
			transaccion.setIdUsuario(item.getIdUser());
			transaccion.setCantidad(item.getQuantity().intValue());
			transaccion.setFecha(new Date());
			Item itemAgregar = em.find(Item.class, item.getIdItem());
			transaccion.setValor(itemAgregar.getValor() * item.getQuantity().intValue());
			em.persist(transaccion);
			return transaccion;
		} catch (Exception e) {
			throw new PersistenceEJBException(
					"CP Ha ocurrido un error al agregar el item al carrito de compras, causa: " + e.getMessage());
		}
	}

	@Override
	public void eliminarItemDeCarrito(Long idTransaccion) throws PersistenceEJBException {
		try {
			Transaccion transaccion = em.find(Transaccion.class, idTransaccion);
			if (transaccion.getEstado().equals(TransaccionEstadoEnum.CARRITO.getValue())
					|| transaccion.getEstado().equals(TransaccionEstadoEnum.PROCESADA_ERRONEA.getValue())) {
				transaccion.setEstado(TransaccionEstadoEnum.ELIMINADA.getValue());
				em.merge(transaccion);
			} else {
				throw new Exception(
						"El item no se puede eliminar dado que se encuentra en estado " + transaccion.getEstado());
			}
		} catch (Exception e) {
			throw new PersistenceEJBException(
					"CP Ha ocurrido un error al agregar el item al carrito de compras, causa: " + e.getMessage());
		}
	}

	@Override
	public List<Transaccion> enCarritoPorEntidad(Long idEntidad) throws PersistenceEJBException {
		try {
			TypedQuery<Transaccion> tQuery = em.createNamedQuery("transacciones.enCarritoPorEntidad",
					Transaccion.class);
			tQuery.setParameter("idEntidad", idEntidad);
			List<Transaccion> transacciones = tQuery.getResultList();
			return transacciones;
		} catch (Exception e) {
			throw new PersistenceEJBException(
					"CP Ha ocurrido un error al cargar los items en el carrito de una entidad, causa: "
							+ e.getMessage());
		}
	}

	@Override
	public void realizarCompra(List<Long> idsTransacciones) throws PersistenceEJBException {
		try{
			//Traer las transferencias
			TypedQuery<Transaccion> tQuery = em.createNamedQuery("transacciones.porIds", Transaccion.class);
			tQuery.setParameter("idsTransacciones", idsTransacciones);
			List<Transaccion> transacciones = tQuery.getResultList();
			//Recorrerlas
			for (Transaccion transaccion : transacciones) {
				transaccion.setEstado(TransaccionEstadoEnum.PROCESADA_VALIDA.getValue());
				em.merge(transaccion);
				Transaccion transaccionHistorial = new Transaccion();
				transaccionHistorial.setEstado(TransaccionEstadoEnum.COMPLETADA.getValue());
				transaccionHistorial.setFecha(new Date());
				transaccionHistorial.setIdItem(transaccion.getIdItem());
				transaccionHistorial.setIdUsuario(transaccion.getIdUsuario());
				transaccionHistorial.setCantidad(transaccion.getCantidad());
				transaccionHistorial.setValor(transaccion.getValor());
				em.persist(transaccionHistorial);
			}
		}catch(Exception e){ 
			throw new PersistenceEJBException("CP Ha ocurrido un error al registrar el pago de las transferencias, causa: "+e.getMessage());
		}
	}

	@Override
	public List<Transaccion> getAllTransaction() throws PersistenceEJBException {
		try {
			TypedQuery<Transaccion> tQuery = em.createNamedQuery("transacciones.getAllTransaction",	Transaccion.class);
			List<Transaccion> transacciones = tQuery.getResultList();
			return transacciones;
		} catch (Exception e) {
			throw new PersistenceEJBException("CP Ha ocurrido un error al cargar los items en el carrito de una entidad, causa: "+ e.getMessage());
		}
	}

	@Override
	public List<Transaccion> obtenerCompras(Long idUsuario) throws PersistenceEJBException {
		try {
			TypedQuery<Transaccion> tQuery = em.createNamedQuery("transacciones.shoppingByEntity",	Transaccion.class);
			tQuery.setParameter("idUsuario", idUsuario);
			return tQuery.getResultList();
		} catch (Exception e) {
			throw new PersistenceEJBException("CP Ha ocurrido un error al consultar las compras de una entidad, causa: "+ e.getMessage());
		}
	}

	@Override
	public List<Transaccion> obtenerVentas(Long idEntidad) throws PersistenceEJBException {
		try {
			TypedQuery<Transaccion> tQuery = em.createNamedQuery("transacciones.salesByEntity",	Transaccion.class);
			tQuery.setParameter("idEntidad", idEntidad);
			return tQuery.getResultList();
		} catch (Exception e) {
			throw new PersistenceEJBException("CP Ha ocurrido un error al consultar las ventas de una entidad, causa: "+ e.getMessage());
		}
	}

	@Override
	public Long cantidadEnCarritoPorEntidad(Long idEntidad) throws PersistenceEJBException {
		try {
			TypedQuery<Long> tQuery = em.createNamedQuery("transacciones.cantidadEnCarritoPorEntidadPorEstado",
					Long.class);
			tQuery.setParameter("estado", TransaccionEstadoEnum.CARRITO.getValue());
			tQuery.setParameter("idEntidad", idEntidad);
			Long transacciones = tQuery.getSingleResult();
			return transacciones;
		} catch (Exception e) {
			throw new PersistenceEJBException(
					"CP Ha ocurrido un error al cargar la cantidad de items en el carrito de una entidad, causa: "
							+ e.getMessage());
		}
	}
	
}
