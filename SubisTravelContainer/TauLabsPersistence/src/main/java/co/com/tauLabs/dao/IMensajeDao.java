package co.com.tauLabs.dao;


import java.util.List;

import co.com.tauLabs.dto.MensajeDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Mensaje;

public interface IMensajeDao extends IGenericDao<Mensaje, Long> {
	
	List<MensajeDTO> obtenerMensajesRecibidosPorUsuario(Long idUsuario) throws PersistenceEJBException;
	
	List<MensajeDTO> obtenerMensajesEnviadosPorUsuario(Long idUsuario) throws PersistenceEJBException;
	
}
