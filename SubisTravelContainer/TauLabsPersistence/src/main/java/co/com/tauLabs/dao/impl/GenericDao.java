package co.com.tauLabs.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IGenericDao;

public abstract class GenericDao<T,ID> implements IGenericDao<T,ID>, Serializable{

	private static final long serialVersionUID = 554771308104758587L;

	final static Logger logger = Logger.getLogger(GenericDao.class);
	
	@PersistenceContext(unitName = "TauLabsEntidadesEJB")
	EntityManager em;
	
	private Class<T> claseEntidad;

    public GenericDao() {

    }
    public GenericDao(EntityManager em) {
    	this.em = em;
    }
    
    @PostConstruct
	@SuppressWarnings("unchecked")
	public void postConstruct() {
		ParameterizedType paramType = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.claseEntidad = (Class<T>) paramType.getActualTypeArguments()[0];
	}
    
    @Override
	public void eliminar(T entidad) throws Exception {
		logger.debug("Modificando la entidad en la base de datos");
		try {
			this.em.remove(entidad);
		} catch (Exception e) {
			throw new Exception("CP Error eliminando entidad de bd, causa: "+e.getMessage(), e);
		}
	}
    
    @Override
	public T obtenerPorId(ID id) throws Exception {
		logger.debug("Obteniendo entidad por id");
		try {
			return (T) em.find(claseEntidad,id);
		} catch (Exception e) {
			throw new Exception("Error eliminando entidad de bd", e);
		}
	}
    
    @Override
	public T guardar(T entidad) throws Exception {
		logger.debug("Creando la entidad en la base de datos");
		try {
			this.em.persist(entidad);
			this.em.flush();
			return entidad;
		} catch (RuntimeException e) {
			throw new Exception("Error almacenando la informacion de la entidad", e);
		}
	}
    
    @SuppressWarnings("unchecked")
	@Override
    public List<T> listar() throws Exception {
		logger.debug("Obteniendo listado de entidades por filtro");
		try {
			String jpql = "SELECT e FROM " + this.claseEntidad.getSimpleName() + " e ORDER BY e.id DESC";
			Query query = this.em.createQuery(jpql);
			return query.getResultList();
		} catch (Exception re) {
			throw new Exception("Error consultando todas las entidades", re);
		}
	}
    
    @Override
	public void modificar(T entidad) throws Exception {
		logger.debug("Modificando la entidad en la base de datos");
		try {
			this.em.merge(entidad);
		} catch (Exception e) {
			throw new Exception("Error almacenando la informacion de la entidad", e);
		}
	}
    

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
}
