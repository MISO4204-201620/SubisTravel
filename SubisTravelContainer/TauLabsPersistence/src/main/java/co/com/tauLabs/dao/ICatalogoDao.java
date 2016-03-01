package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.model.Catalogo;
import co.com.tauLabs.model.Contenido;
import co.com.tauLabs.model.Entidad;

public interface ICatalogoDao extends IGenericDao<Catalogo, Long> {
	
	List<Catalogo> listar() throws Exception;
	
}
