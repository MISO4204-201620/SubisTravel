package co.com.tauLabs.service.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IEntidadDao;
import co.com.tauLabs.dao.IUsuarioDao;
import co.com.tauLabs.dto.LoginDTO;
import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.dto.SocialLoginDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.service.IUsuarioService;

@Stateless
@Named
public class UsuarioService implements IUsuarioService {

	@Inject private IUsuarioDao usuarioDao;
	@Inject private IEntidadDao entidadDao;

	final static Logger logger = Logger.getLogger(UsuarioService.class);

//	@Override
//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
//	public SessionClientDTO accederConSocialId(SocialLoginDTO socialLoginDTO)  throws ServiceEJBException{
//		logger.debug("CS iniciando metodo accederConSocialId()");
//		try{
//			if(socialLoginDTO==null) throw new Exception("El objeto de login social es nulo");
//			if(socialLoginDTO.getSocialId()==null) throw new Exception("El id social es nulo");
//			
//			SessionClientDTO sessionClient = usuarioDao.accederConSocialId(socialLoginDTO.getSocialId());
//			
//			if(sessionClient!=null){
//				Entidad entidad = entidadDao.obtenerPorId(sessionClient.getIdEntity());
//				boolean cambios = false;
//				if(entidad.getImagenPrincipal()==null || entidad.getImagenPrincipal().equals("") || !entidad.getImagenPrincipal().equals(socialLoginDTO.getPicture())){
//					entidad.setImagenPrincipal(socialLoginDTO.getPicture());
//				}
//				if(!entidad.getNombre().equals(socialLoginDTO.getName())){
//					entidad.setNombre(socialLoginDTO.getName());
//				}
//				if(cambios){
//					entidadDao.modificar(entidad);
//				}
//			}else{
//				sessionClient = usuarioDao.altaConSocialId(socialLoginDTO);
//			}
//			return sessionClient;
//		}catch(PersistenceEJBException e){
//			throw new ServiceEJBException(e.getMessage());
//		}catch(Exception e){
//			throw new ServiceEJBException("CS Ha ocurrido un error guardando la calificacion, causa: "+e.getMessage());
//		}
//	}
//
//	@Override
//	public SessionClientDTO validarLogin(LoginDTO loginDTO) throws ServiceEJBException {
//		logger.debug("CS iniciando metodo validarLogin()");
//		try{
//			if(loginDTO==null) throw new Exception("El objeto de logueo es nulo");
//			if(loginDTO.getEmail()==null) throw new Exception("El correo ingresado es nulo");
//			if(loginDTO.getPassword()==null) throw new Exception("El password ingresado es nulo");
//	
//			return usuarioDao.validarLogin(loginDTO);
//		}catch(PersistenceEJBException e){
//			throw new ServiceEJBException(e.getMessage());
//		}catch(Exception e){
//			throw new ServiceEJBException("CS Ha ocurrido un error guardando la calificacion, causa: "+e.getMessage());
//		}
//	}

	@Override
	public SessionClientDTO validarLogin(SessionClientDTO sessionClientDTO) throws ServiceEJBException {
		// TODO Auto-generated method stub
		return null;
	}
}
