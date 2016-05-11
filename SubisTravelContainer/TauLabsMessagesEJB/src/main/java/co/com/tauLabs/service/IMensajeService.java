package co.com.tauLabs.service;

import java.util.List;

import javax.ejb.Local;

import co.com.tauLabs.dto.MensajeDTO;
import co.com.tauLabs.exception.ServiceEJBException;

@Local
public interface IMensajeService {

	MensajeDTO enviarMensaje(MensajeDTO mensaje) throws ServiceEJBException;
	
	List<MensajeDTO> obtenerMensajesRecibidosPorUsuario(Long idUsuario) throws Exception;
	
	List<MensajeDTO> obtenerMensajesEnviadosPorUsuario(Long idUsuario) throws Exception;

}
