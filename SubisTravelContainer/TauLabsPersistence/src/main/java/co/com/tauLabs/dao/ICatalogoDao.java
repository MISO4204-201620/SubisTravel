package co.com.tauLabs.dao;

import java.util.List;

import co.com.tauLabs.model.Catalogo;

public interface ICatalogoDao extends IGenericDao<Catalogo, Long> {
	
	List<Catalogo> listar() throws Exception;
	
}
