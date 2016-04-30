package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.dto.ReportBusquedaDTO;
import co.com.tauLabs.dto.ReportConsultaDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Item;

public interface IItemDao extends IGenericDao<Item, Long> {
	
	PaginateDTO filtrados(FilterDTO filtros) throws PersistenceEJBException;
	Item obtenerItemPorId(Long id) throws PersistenceEJBException;
	Boolean permiteCalificarItemPorUsuario(Long id,Long idUsuario) throws PersistenceEJBException;
	List<ReportBusquedaDTO> reporteBusquedaItems(Long idUsuario) throws PersistenceEJBException;
	List<ReportConsultaDTO> reporteConsultaItems(Long idUsuario) throws PersistenceEJBException;
}
