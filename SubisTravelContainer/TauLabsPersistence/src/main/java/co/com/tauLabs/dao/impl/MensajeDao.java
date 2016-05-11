package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.IMensajeDao;
import co.com.tauLabs.dto.MensajeDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Mensaje;

@Stateless
@Named
public class MensajeDao extends GenericDao<Mensaje, Long> implements IMensajeDao, Serializable {

	private static final long serialVersionUID = 554771308104758587L;

	public MensajeDao() {

	}

	@PersistenceContext(unitName = "TauLabsEntidadesEJB")
	EntityManager em;

	@Override
	public List<MensajeDTO> obtenerMensajesRecibidosPorUsuario(Long idUsuario) throws PersistenceEJBException {
		// TODO Auto-generated method stub
		logger.debug("CP iniciando metodo obtenerMensajesRecibidosPorUsuario()");
		try {
			if (idUsuario == null)
				throw new Exception("El identificador es nulo");
			TypedQuery<Object> namedQuery = this.em.createNamedQuery(QueryName.MENSAJE_BY_USER_TO.getValue(),
					Object.class);
			namedQuery.setParameter("idUsuario", idUsuario);
			List<Object> resultList = namedQuery.getResultList();
			List<MensajeDTO> lstMensajes = new ArrayList<MensajeDTO>();
			for (Object result : resultList) {
				Object[] r = (Object[]) result;
				MensajeDTO mensaje = new MensajeDTO();
				mensaje.setId((Long) r[0]);
				mensaje.setAsunto(r[1].toString());
				mensaje.setMensaje(r[2].toString());

				mensaje.setFecha((Date)(Object)r[3]);

				mensaje.setIdUsuarioDestino((Long) r[4]);
				mensaje.setIdUsuarioOrigen((Long) r[5]);
				mensaje.setNombreUsuarioDestino(r[6].toString());
				mensaje.setNombreUsuarioOrigen(r[7].toString());
				if (r[8] != null) {

					mensaje.setIdMensajeRelacionado((Long) r[8]);
				}

				lstMensajes.add(mensaje);
			}
			return lstMensajes;
		} catch (Exception e) {
			logger.error("CP Error consultando obtenerMensajesRecibidosPorUsuario, causa: " + e.getMessage());
			throw new PersistenceException(
					"CP Error ejecutnao el metodo obtenerMensajesRecibidosPorUsuario,causa: " + e.getMessage());
		}
	}

	@Override
	public List<MensajeDTO> obtenerMensajesEnviadosPorUsuario(Long idUsuario) throws PersistenceEJBException {
		// TODO Auto-generated method stub
				logger.debug("CP iniciando metodo obtenerMensajesEnviadosPorUsuario()");
				try {
					if (idUsuario == null)
						throw new Exception("El identificador es nulo");
					TypedQuery<Object> namedQuery = this.em.createNamedQuery(QueryName.MENSAJE_BY_USER_FROM.getValue(),
							Object.class);
					namedQuery.setParameter("idUsuario", idUsuario);
					List<Object> resultList = namedQuery.getResultList();
					List<MensajeDTO> lstMensajes = new ArrayList<MensajeDTO>();
					for (Object result : resultList) {
						Object[] r = (Object[]) result;
						MensajeDTO mensaje = new MensajeDTO();
						mensaje.setId((Long) r[0]);
						mensaje.setAsunto(r[1].toString());
						mensaje.setMensaje(r[2].toString());

						mensaje.setFecha((Date)(Object)r[3]);

						mensaje.setIdUsuarioDestino((Long) r[4]);
						mensaje.setIdUsuarioOrigen((Long) r[5]);
						mensaje.setNombreUsuarioDestino(r[6].toString());
						mensaje.setNombreUsuarioOrigen(r[7].toString());
						if (r[8] != null) {

							mensaje.setIdMensajeRelacionado((Long) r[8]);
						}

						lstMensajes.add(mensaje);
					}
					return lstMensajes;
				} catch (Exception e) {
					logger.error("CP Error consultando obtenerMensajesEnviadosPorUsuario, causa: " + e.getMessage());
					throw new PersistenceException(
							"CP Error ejecutnao el metodo obtenerMensajesEnviadosPorUsuario,causa: " + e.getMessage());
				}
	}

}
