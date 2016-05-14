package co.com.tauLabs.service.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IEntidadDao;
import co.com.tauLabs.dao.IUsuarioDao;
import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.service.ISocialLoginService;

@Stateless
@Named
public class SocialLoginService implements ISocialLoginService {

	@Inject
	private IUsuarioDao usuarioDao;
	@Inject
	private IEntidadDao entidadDao;

	final static Logger logger = Logger.getLogger(SocialLoginService.class);

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public SessionClientDTO validarLogin(SessionClientDTO sessionClientDTO) throws ServiceEJBException {
		logger.debug("CS iniciando metodo accederConSocialId()");
		try {
			if (sessionClientDTO.getIdEntity() == null && sessionClientDTO.getSocialId()!=null) {
				SessionClientDTO sessionClient = usuarioDao.accederConSocialId(sessionClientDTO.getSocialId());

				if (sessionClient != null) {
					Entidad entidad = entidadDao.obtenerPorId(sessionClient.getIdEntity());
					boolean cambios = false;
					if (entidad.getImagenPrincipal() == null || entidad.getImagenPrincipal().equals("")
							|| !entidad.getImagenPrincipal().equals(sessionClientDTO.getPicture())) {
						entidad.setImagenPrincipal(sessionClientDTO.getPicture());
					}
					if (!entidad.getNombre().equals(sessionClientDTO.getName())) {
						entidad.setNombre(sessionClientDTO.getName());
					}
					if (cambios) {
						entidadDao.modificar(entidad);
					}
				} else {
					sessionClient = usuarioDao.altaConSocialId(sessionClientDTO);
				}
				sessionClient.setName(sessionClientDTO.getName());
				sessionClient.setPicture(sessionClientDTO.getPicture());
				sessionClientDTO = sessionClient;
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
