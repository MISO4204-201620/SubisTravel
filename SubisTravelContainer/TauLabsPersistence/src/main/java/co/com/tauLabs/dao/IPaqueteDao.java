package co.com.tauLabs.dao;



import co.com.tauLabs.dto.PaqueteDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Paquete;

public interface IPaqueteDao extends IGenericDao<Paquete, Long> {

	PaqueteDTO obtenerPaquetePorItemPaquete(Long idItemPaquete) throws PersistenceEJBException;
	
	PaqueteDTO guardarPaquete(PaqueteDTO paqueteDTO)throws PersistenceEJBException;
}
