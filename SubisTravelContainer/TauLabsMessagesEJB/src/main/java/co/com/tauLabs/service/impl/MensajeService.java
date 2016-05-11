package co.com.tauLabs.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IMensajeDao;
import co.com.tauLabs.dto.MensajeDTO;
import co.com.tauLabs.enums.MensajeEstadoEnum;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Mensaje;
import co.com.tauLabs.service.IMensajeService;

@Stateless
@Named
public class MensajeService implements IMensajeService,Serializable {

	final static Logger logger = Logger.getLogger(MensajeService.class);

	private static final long serialVersionUID = 1L;

	@EJB private IMensajeDao mensajeDao;

	public MensajeService() {
		
    }

	@Override
	public MensajeDTO enviarMensaje(MensajeDTO mensaje) throws ServiceEJBException {
		try{
			
			Mensaje objMensaje = new Mensaje();
			objMensaje.setAsunto(mensaje.getAsunto());
			objMensaje.setMensaje(mensaje.getMensaje());
			objMensaje.setIdUsuarioDestino(mensaje.getIdUsuarioDestino());
			objMensaje.setIdUsuarioOrigen(mensaje.getIdUsuarioOrigen());
			objMensaje.setFecha(new Date());
			objMensaje.setIdMensajeRelacionado(mensaje.getIdMensajeRelacionado());
			objMensaje.setEstado(MensajeEstadoEnum.ACTIVO.getValue());
			objMensaje = mensajeDao.guardar(objMensaje);
			mensaje.setId(objMensaje.getId());
			mensaje.setFecha(objMensaje.getFecha());
			//mensaje.setNombreUsuarioDestino(objMensaje.getUsuarioDestino().getEntidad().getNombre());
			//mensaje.setNombreUsuarioOrigen(objMensaje.getUsuarioOrigen().getEntidad().getNombre());
			return mensaje;
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al enviar mensaje, causa: "+e.getMessage());
		}
	}
	
	@Override
	public List<MensajeDTO> obtenerMensajesRecibidosPorUsuario(Long idUsuario) throws Exception {
		logger.debug("CS iniciando metodo obtenerMensajesRecibidosPorUsuario()");
		try{
			if(idUsuario==null) throw new Exception("el id del usuario es nulo");
			return mensajeDao.obtenerMensajesRecibidosPorUsuario(idUsuario);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al consultar Mensajes recibidos por usuario, causa: "+e.getMessage());
		}
	}
	
	@Override
	public List<MensajeDTO> obtenerMensajesEnviadosPorUsuario(Long idUsuario)  throws Exception {
		logger.debug("CS iniciando metodo obtenerMensajesEnviadosPorUsuario()");
		try{
			if(idUsuario==null) throw new Exception("el id del usuario es nulo");
			return mensajeDao.obtenerMensajesEnviadosPorUsuario(idUsuario);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al consultar Mensajes enviados por usuario, causa: "+e.getMessage());
		}
	}
	
	

}
