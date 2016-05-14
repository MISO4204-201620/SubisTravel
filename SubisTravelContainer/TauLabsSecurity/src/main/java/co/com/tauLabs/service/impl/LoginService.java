package co.com.tauLabs.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.enums.ServiciosActivosEnum;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.service.IBaseLoginService;
import co.com.tauLabs.service.ILoginService;
import co.com.tauLabs.service.ISocialLoginService;

@Stateless
@Named
public class LoginService implements ILoginService {

	@Inject
	private IBaseLoginService baseLoginService;
	@Inject
	private ISocialLoginService socialLoginService;

	final static Logger logger = Logger.getLogger(LoginService.class);

	@Override
	public SessionClientDTO validarLogin(SessionClientDTO sessionClientDTO) throws ServiceEJBException {
		logger.debug("CS iniciando metodo validarLogin() en el central de decoración");
		try {

			sessionClientDTO = baseLoginService.validarLogin(sessionClientDTO);
			
			if (ServiciosActivosEnum.SOCIAL_AUTHENTICATION.getValue()) {
				sessionClientDTO = socialLoginService.validarLogin(sessionClientDTO);
			}

			return sessionClientDTO;
		} catch (PersistenceEJBException e) {
			throw new ServiceEJBException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceEJBException(
					"CS Ha ocurrido un error guardando la calificacion, causa: " + e.getMessage());
		}
	}
}
