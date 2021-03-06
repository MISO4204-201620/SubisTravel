package co.com.tauLabs.service;

import javax.ejb.Local;

import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.exception.ServiceEJBException;

@Local
public interface ILoginService {

	SessionClientDTO validarLogin(SessionClientDTO sessionClientDTO) throws ServiceEJBException;

}
