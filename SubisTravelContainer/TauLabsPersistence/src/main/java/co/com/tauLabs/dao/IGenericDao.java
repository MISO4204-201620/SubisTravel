package co.com.tauLabs.dao;

import java.util.List;

public interface IGenericDao<T,ID> {
	
	T guardar(T entidad) throws Exception;
	
	List<T> listar() throws Exception;
	
	T obtenerPorId(ID id) throws Exception;
	
	void modificar(T entidad) throws Exception;
	
	void eliminar(T entidad) throws Exception;
	
}
