package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.IUsuarioDao;
import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.dto.UsuarioDTO;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.model.RedSocialUsuario;
import co.com.tauLabs.model.Usuario;

@Stateless
public class UsuarioDao extends GenericDao<Usuario, Long> implements IUsuarioDao, Serializable {

	private static final long serialVersionUID = 554771308104758587L;

	public UsuarioDao() {

	}

	@Override
	public List<Usuario> clientesPorEntidad(Long idEntidad) throws ServiceEJBException {
		logger.debug("CP iniciando metodo clientesPorEntidad()");
		try {
			if (idEntidad == null)
				throw new Exception("El identificador de la entidad es nulo");

			TypedQuery<Usuario> namedQuery = this.em.createNamedQuery(QueryName.USUARIO_CLIENTS_BY_ENTITY.getValue(),
					Usuario.class);
			namedQuery.setParameter("idEntidad", idEntidad);
			return namedQuery.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new ServiceEJBException("CP Error consultando contenidos de un item, causa: " + e.getMessage());
		}
	}

	@Override
	public SessionClientDTO validarLogin(SessionClientDTO sessionClientDTO) throws ServiceEJBException {
		logger.debug("CP iniciando metodo validarLogin()");
		try {
			if (sessionClientDTO.getEmail() != null && !sessionClientDTO.getEmail().trim().isEmpty()
					&& sessionClientDTO.getPassword() != null && !sessionClientDTO.getPassword().trim().isEmpty()) {

				TypedQuery<Usuario> namedQuery = this.em.createNamedQuery(QueryName.USUARIO_BY_EMAIL.getValue(),
						Usuario.class);
				namedQuery.setParameter("email", sessionClientDTO.getEmail());
				namedQuery.setMaxResults(1);
				Usuario usuario = namedQuery.getSingleResult();

				if (usuario.getPassword().equals(sessionClientDTO.getPassword())) {
					sessionClientDTO.setIdEntity(usuario.getIdEntidad());
					sessionClientDTO.setIdType(usuario.getEntidad().getIdTipo());
				}
			}
			return sessionClientDTO;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new ServiceEJBException("CP Error consultando contenidos de un item, causa: " + e.getMessage());
		}
	}

	@Override
	public SessionClientDTO accederConSocialId(String socialId) throws ServiceEJBException {
		logger.debug("CP iniciando metodo accederConSocialId()");
		try {
			if (socialId == null)
				throw new Exception("El identificador social es nulo");

			TypedQuery<Usuario> namedQuery = this.em.createNamedQuery(QueryName.USUARIO_BY_SOCIAL_ID.getValue(),
					Usuario.class);
			namedQuery.setParameter("socialId", socialId);
			namedQuery.setMaxResults(1);
			Usuario usuario = namedQuery.getSingleResult();
			SessionClientDTO session = new SessionClientDTO();
			session.setIdUser(usuario.getId());
			session.setIdEntity(usuario.getIdEntidad());
			Entidad entidad = em.find(Entidad.class, usuario.getIdEntidad());
			session.setIdType(entidad.getIdTipo());
			return session;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new ServiceEJBException("CP Error consultando sessión con social id, causa: " + e.getMessage());
		}
	}

	@Override
	public SessionClientDTO altaConSocialId(SessionClientDTO sessionClientDTO) throws ServiceEJBException {
		logger.debug("CP iniciando metodo accederConSocialId()");
		try {
			// Se crea una entidad
			Entidad entidad = new Entidad();
			entidad.setIdTipo(3L);
			entidad.setNombre(sessionClientDTO.getName());
			em.persist(entidad);
			em.flush();
			// Se crea un usuario
			Usuario usuario = new Usuario();
			usuario.setEstado("ACTIVO");
			usuario.setIdEntidad(entidad.getId());
			em.persist(usuario);
			em.flush();
			// Se asocia a una cuenta de red social
			RedSocialUsuario redSocialUsuario = new RedSocialUsuario();
			redSocialUsuario.setIdUsuario(usuario.getId());
			redSocialUsuario.setIdentificador(sessionClientDTO.getSocialId());
			if (sessionClientDTO.getProvider() == null || sessionClientDTO.getProvider().equals("")) {
				redSocialUsuario.setIdRedSocial(4L);
			} else if (sessionClientDTO.getProvider().equals("twitter")) {
				redSocialUsuario.setIdRedSocial(2L);
			} else if (sessionClientDTO.getProvider().equals("facebook")) {
				redSocialUsuario.setIdRedSocial(1L);
			}
			em.persist(redSocialUsuario);
			em.flush();
			// Se define el objeto sessionClient para la sessión del usuario
			SessionClientDTO sessionClient = new SessionClientDTO();
			sessionClient.setIdEntity(entidad.getId());
			sessionClient.setIdType(3L);
			sessionClient.setIdUser(usuario.getId());
			return sessionClient;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new ServiceEJBException("CP Error consultando sessión con social id, causa: " + e.getMessage());
		}
	}

	@Override
	public List<UsuarioDTO> obtenerUsuariosPorTipo(String tipo) throws PersistenceException {
		// TODO Auto-generated method stub
		logger.debug("CP iniciando metodo obtenerUsuariosPorTipo()");
		try {
			if (tipo == null)
				throw new Exception("El tipo es nulo");
			TypedQuery<Object> namedQuery = this.em.createNamedQuery(QueryName.USUARIO_BY_TIPO.getValue(),
					Object.class);
			namedQuery.setParameter("tipo", tipo);
			List<Object> resultList = namedQuery.getResultList();
			List<UsuarioDTO> lstUsuariosDTO = new ArrayList<UsuarioDTO>();
			if (!resultList.isEmpty()) {
				for (Object result : resultList) {
					Object[] r = (Object[]) result;
					UsuarioDTO usuario = new UsuarioDTO();
					// usuario.setDireccion(r[1].toString());
					usuario.setIdUsuario((Long) r[0]);
					if (r[2] != null) {
						usuario.setEmail(r[2].toString());
					}
					// usuario.setEstado(r[1].toString());
					// usuario.setIdentificacion(r[1].toString());
					usuario.setNombre(r[3].toString());
					if (r[1] != null) {
						usuario.setLogin(r[1].toString());
					}
					lstUsuariosDTO.add(usuario);
				}
			}

			return lstUsuariosDTO;
		} catch (Exception e) {
			logger.error("CP Error consultando obtenerUsuariosPorTipo, causa: " + e.getMessage());
			throw new PersistenceException(
					"CP Error ejecutando el metodo obtenerUsuariosPorTipo,causa: " + e.getMessage());
		}
	}

}
