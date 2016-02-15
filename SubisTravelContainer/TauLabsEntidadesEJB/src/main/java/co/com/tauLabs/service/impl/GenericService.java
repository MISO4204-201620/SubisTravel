package co.com.tauLabs.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IGenericDao;
import co.com.tauLabs.service.IGenericService;
import co.com.tauLabs.service.rest.EntidadServiceRS;

@Stateless
@Named
public abstract class GenericService<Entidad,ID> implements IGenericService<Entidad,ID>, Serializable{

	private static final long serialVersionUID = 554771308104758587L;

	final static Logger logger = Logger.getLogger(EntidadServiceRS.class);
	
	IGenericDao<Entidad, ID> genericDao; 
	
    public GenericService() {

    }
    
    @Override
	public void eliminar(Entidad entidad) throws Exception {
		logger.debug("Modificando la entidad en la base de datos");
		try {
			this.genericDao.eliminar(entidad);
		} catch (Exception e) {
			throw new Exception("Error eliminando entidad de bd", e);
		}
	}

	@Override
	public Entidad obtenerPorId(ID id) throws Exception {
		logger.debug("Modificando la entidad en la base de datos");
		try {
			return this.genericDao.obtenerPorId(id);
		} catch (Exception e) {
			throw new Exception("Error obteniendo entidad por id", e);
		}
	}
    
    @Override
	public Entidad guardar(Entidad entidad) throws Exception {
		logger.debug("Creando la entidad en la base de datos");
		try {
			this.genericDao.guardar(entidad);
			return entidad;
		} catch (RuntimeException e) {
			throw new Exception("Error almacenando la informacion de la entidad", e);
		}
	}
    
	@Override
    public List<Entidad> listar() throws Exception {
		logger.debug("Obteniendo listado de entidades por filtro");
		try {
			return this.genericDao.listar();
		} catch (Exception re) {
			throw new Exception("Error consultando todas las entidades", re);
		}
	}
    
    @Override
	public void modificar(Entidad entidad) throws Exception {
		logger.debug("Modificando la entidad en la base de datos");
		try {
			this.genericDao.modificar(entidad);
		} catch (Exception e) {
			throw new Exception("Error almacenando la informacion de la entidad", e);
		}
	}
    
}
