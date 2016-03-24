package co.com.tauLabs.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IUsuarioDao;
import co.com.tauLabs.dto.LoginDTO;
import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.service.IUsuarioService;

@Stateless
@Named
public class UsuarioService implements IUsuarioService {

	@Inject private IUsuarioDao usuarioDao;

	final static Logger logger = Logger.getLogger(UsuarioService.class);
	
	@Override
	public SessionClientDTO validarLogin(LoginDTO loginDTO) throws ServiceEJBException {
		logger.debug("CS iniciando metodo validarLogin()");
		try{
			if(loginDTO==null) throw new Exception("El objeto de logueo es nulo");
			if(loginDTO.getEmail()==null) throw new Exception("El correo ingresado es nulo");
			if(loginDTO.getPassword()==null) throw new Exception("El password ingresado es nulo");
	
			return usuarioDao.validarLogin(loginDTO);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error guardando la calificacion, causa: "+e.getMessage());
		}
	}
	
	@Override
	public SessionClientDTO accederConSocialId(String socialId)  throws ServiceEJBException{
		logger.debug("CS iniciando metodo accederConSocialId()");
		try{
			if(socialId==null) throw new Exception("El identificador social es nulo");
	
			return usuarioDao.accederConSocialId(socialId);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error guardando la calificacion, causa: "+e.getMessage());
		}
	}
}
