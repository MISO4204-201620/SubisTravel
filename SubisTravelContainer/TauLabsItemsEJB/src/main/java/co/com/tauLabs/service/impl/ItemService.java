package co.com.tauLabs.service.impl;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IItemDao;
import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.enums.ItemEstadoEnum;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.exception.ValidationException;
import co.com.tauLabs.model.Item;
import co.com.tauLabs.service.IItemService;

@Stateless
@Named
public class ItemService implements IItemService, Serializable {

	final static Logger logger = Logger.getLogger(ItemService.class);

	private static final long serialVersionUID = 1L;

	@Inject
	private IItemDao itemDao;


	public ItemService() {

	}

	@Override
	public PaginateDTO filtrados(FilterDTO filtros) throws ServiceEJBException {
		logger.debug("CS iniciando metodo filtrados()");
		try {
			if (filtros == null)
				throw new ValidationException("El filtro ingresado es nulo");
			return itemDao.filtrados(filtros);
		} catch (PersistenceEJBException e) {
			throw new ServiceEJBException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceEJBException(
					"CS Ha ocurrido un error consultando items por filtros, causa: " + e.getMessage());
		}

	}

	@Override
	public Item obtenerItemPorId(Long id) throws ServiceEJBException {
		logger.debug("CS iniciando metodo obtenerItemPorId()");
		try {
			if (id == null)
				throw new Exception("El ID ingresado es nulo");
			return itemDao.obtenerItemPorId(id);
		} catch (PersistenceEJBException e) {
			throw new ServiceEJBException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceEJBException("CS Ha ocurrido un error consultando Item por id, causa: " + e.getMessage());
		}
	}

	@Override
	public Boolean permiteCalificarItemPorUsuario(Long id, Long idUsuario) throws ServiceEJBException {
		logger.debug("CS iniciando metodo obtenerItemPorId()");
		try {
			if (idUsuario == null)
				throw new Exception("El ID ingresado es nulo");
			return itemDao.permiteCalificarItemPorUsuario(id, idUsuario);
		} catch (PersistenceEJBException e) {
			throw new ServiceEJBException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceEJBException(
					"CS Ha ocurrido validando si permite calificar un item por idUsuario, causa: " + e.getMessage());
		}
	}

	@Override
	public Item crearItem(Item item) throws ServiceEJBException {
		try {
			item.setEstado(ItemEstadoEnum.PUBLICADO.getValue());
			return itemDao.guardar(item);
		} catch (Exception e) {
			throw new ServiceEJBException("CS Ha ocurrido un error al crear el îtem, causa: " + e.getMessage());
		}
	}

	@Override
	public Item publicarItem(Long id) throws ServiceEJBException {
		try {
			Item item = this.obtenerItemPorId(id);
			item.setEstado(ItemEstadoEnum.PUBLICADO.getValue());
			itemDao.modificar(item);
			return item;
		} catch (Exception e) {
			throw new ServiceEJBException("CS Ha ocurrido un error al crear el îtem, causa: " + e.getMessage());
		}
	}

	@Override
	public Item actualizarItem(Long id, Item item) throws ServiceEJBException {
		try {
			if (id == null)
				throw new Exception("El ID ingresado es nulo");
			Item i = this.obtenerItemPorId(id);
			if (i != null) {

				if (item.getDescripcion() != null && item.getDescripcion().length() > 0
						&& item.getDescripcion() != i.getDescripcion()) {
					i.setDescripcion(item.getDescripcion());
				}
				if (item.getIdTipo() != null && item.getIdTipo() > 0 && item.getIdTipo() != i.getIdTipo()) {
					i.setIdTipo(item.getIdTipo());
				}
				if (item.getIdClasificacion() != null && item.getIdClasificacion() > 0
						&& item.getIdClasificacion() != i.getIdClasificacion()) {
					i.setIdClasificacion(item.getIdClasificacion());
				}
				if (item.getNombre() != null && item.getNombre() != i.getNombre()) {
					i.setNombre(item.getNombre());
				}
				if (item.getValor() != null && item.getValor() != i.getValor()) {
					i.setValor(item.getValor());
				}
				if (item.getImagen() != null && item.getImagen() != i.getImagen()) {
					i.setImagen(item.getImagen());
				}
				if (item.getEstado() != null && item.getEstado().length() > 0 && item.getEstado() != i.getEstado()
						&& (item.getEstado().equals(ItemEstadoEnum.PUBLICADO.getValue())
								|| item.getEstado().equals(ItemEstadoEnum.CREADO.getValue())
								|| item.getEstado().equals(ItemEstadoEnum.ELIMINADO.getValue()))) {
					i.setEstado(item.getEstado());
				}
				if (item.getDescripcionCantidad() != null
						&& item.getDescripcionCantidad() != i.getDescripcionCantidad()) {
					i.setDescripcionCantidad(item.getDescripcionCantidad());
				}
				itemDao.modificar(i);
			} else {
				throw new Exception("No existe el item con el ID ingresado");
			}
			return item;
		} catch (Exception e) {
			throw new ServiceEJBException("CS Ha ocurrido un error al modificar el îtem, causa: " + e.getMessage());
		}
	}

}
