package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import co.com.tauLabs.constant.QueryName;
import co.com.tauLabs.dao.IItemDao;
import co.com.tauLabs.dao.IPaqueteDao;
import co.com.tauLabs.dto.PaqueteDTO;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Paquete;

@Stateless
@Named
public class PaqueteDao extends GenericDao<Paquete, Long> implements IPaqueteDao, Serializable {

	private static final long serialVersionUID = 554771308104758587L;

	public PaqueteDao() {

	}

	@PersistenceContext(unitName = "TauLabsEntidadesEJB")
	EntityManager em;

	@Inject
	private IItemDao itemDao;
	
	@Override
	public PaqueteDTO obtenerPaquetePorItemPaquete(Long idItemPaquete) throws PersistenceEJBException {
		logger.debug("CP iniciando metodo obtenerPaquetePorItemPaquete()");
		try {
			PaqueteDTO paqueteDTO = new PaqueteDTO();
			paqueteDTO.setIdsItemsIncluidos(new ArrayList<Long>());
			paqueteDTO.setItemsIncluidos(new ArrayList<Object>());
			if (idItemPaquete == null)
				throw new Exception("El identificador es nulo");
			TypedQuery<Paquete> namedQuery = this.em.createNamedQuery(QueryName.PAQUETE_BY_ITEM_PAQUETE.getValue(),
					Paquete.class);
			namedQuery.setParameter("idItemPaquete", idItemPaquete);
			List<Paquete> rgsPaquete = namedQuery.getResultList();
			if (rgsPaquete.size() > 0) {
				paqueteDTO.setItemPaquete(rgsPaquete.get(0).getItemPaquete());
				paqueteDTO.setIdItemPaquete(rgsPaquete.get(0).getIdItemPaquete());
				for (Paquete rg : rgsPaquete) {
					paqueteDTO.getItemsIncluidos().add(rg.getItemIncluido());
					paqueteDTO.getIdsItemsIncluidos().add(rg.getIdItemIncluido());
				}
			}
			return paqueteDTO;
		} catch (Exception e) {
			logger.error("CP Erro consultando Paquetes por itemPaquete, causa: " + e.getMessage());
			throw new PersistenceException(
					"CP Error ejecutnao el metodo obtenerPaquetePorItemPaquete,causa: " + e.getMessage());
		}
	}

	public PaqueteDTO guardarPaquete(PaqueteDTO paqueteDTO) throws PersistenceEJBException {

		logger.debug("CP iniciando metodo guardarPaquete()");
		try {
			if (paqueteDTO == null){
				throw new Exception("El objeto es nulo");
			}	
			TypedQuery<Paquete> namedQuery = this.em.createNamedQuery(QueryName.PAQUETE_BY_ITEM_PAQUETE.getValue(),Paquete.class);
			namedQuery.setParameter("idItemPaquete", paqueteDTO.getIdItemPaquete());
			List<Paquete> rgsPaquete = namedQuery.getResultList();
			List<Paquete> rgsPaqueteTotal = new ArrayList<Paquete>();
			rgsPaqueteTotal.addAll(rgsPaquete);
			if (rgsPaquete.size() > 0) {
				// Se recorren los registros existentes para agregar lo que no
				// existen
				for (Long idItemIncluido : paqueteDTO.getIdsItemsIncluidos()) {
					boolean band = false;
					for (Paquete paquete : rgsPaquete) {
						if (paquete.getIdItemIncluido() == idItemIncluido) {
							band = true;
						}
					}
					if (!band) {
						Paquete pack = new Paquete();
						pack.setIdItemPaquete(paqueteDTO.getIdItemPaquete());
						pack.setIdItemIncluido(idItemIncluido);
						pack.setItemIncluido(itemDao.obtenerItemPorId(idItemIncluido));
						pack.setItemPaquete(itemDao.obtenerItemPorId(paqueteDTO.getIdItemPaquete()));
						em.persist(pack);
						rgsPaqueteTotal.add(pack);
					}
				}
				// Se recorren los registro resultantes para eliminar los que no
				// se incluyen en el objeto de entrada
				for (Paquete rgTotal : rgsPaqueteTotal) {
					boolean band = false;
					for (Long idItemIncluido : paqueteDTO.getIdsItemsIncluidos()) {
						if (rgTotal.getIdItemIncluido() == idItemIncluido) {
							band = true;
						}
					}
					if (!band) {
						this.eliminar(rgTotal);
					}
				}
			} else {
				//Si no existen elementos en BD se crean todos.
				for (Long idItemIncluido : paqueteDTO.getIdsItemsIncluidos()) {
					Paquete pack = new Paquete();
					pack.setIdItemPaquete(paqueteDTO.getIdItemPaquete());
					pack.setIdItemIncluido(idItemIncluido);
					pack.setItemIncluido(itemDao.obtenerItemPorId(idItemIncluido));
					pack.setItemPaquete(itemDao.obtenerItemPorId(paqueteDTO.getIdItemPaquete()));
					em.persist(pack);
					rgsPaqueteTotal.add(pack);
				}
			}
			paqueteDTO = this.obtenerPaquetePorItemPaquete(paqueteDTO.getIdItemPaquete());
			return paqueteDTO;
		} catch (Exception e) {
			logger.error("CP Error guardando Paquete por itemPaquete, causa: " + e.getMessage());
			throw new PersistenceException(
					"CP Error ejecutnao el metodo guardarPaquete,causa: " + e.getMessage());
		}

	}

}
