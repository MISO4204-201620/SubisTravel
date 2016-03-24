package co.com.tauLabs.service;

import javax.ejb.Local;

import co.com.tauLabs.dto.LoginDTO;
import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.exception.ServiceEJBException;

@Local
public interface IUsuarioService {

	SessionClientDTO validarLogin(LoginDTO loginDTO)  throws ServiceEJBException;
	
	SessionClientDTO accederConSocialId(String socialId)  throws ServiceEJBException;
}
