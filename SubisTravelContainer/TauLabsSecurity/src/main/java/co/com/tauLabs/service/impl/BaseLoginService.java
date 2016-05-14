package co.com.tauLabs.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IUsuarioDao;
import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.service.IBaseLoginService;

@Stateless
@Named
public class BaseLoginService implements IBaseLoginService {

	@Inject
	private IUsuarioDao usuarioDao;

	final static Logger logger = Logger.getLogger(BaseLoginService.class);

	@Override
	public SessionClientDTO validarLogin(SessionClientDTO sessionClientDTO) throws ServiceEJBException {
		logger.debug("CS iniciando metodo validarLogin() de la base de login");
		try {

			return usuarioDao.validarLogin(sessionClientDTO);
		} catch (PersistenceEJBException e) {
			throw new ServiceEJBException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceEJBException(
					"CS Ha ocurrido un error logueando la entidad por usuario y contraseñ, causa: " + e.getMessage());
		}
	}
}
