package co.com.tauLabs.service;

import java.util.List;

public interface IGenericService<T,ID> {
	
	T guardar(T entidad) throws Exception;
	
	List<T> listar() throws Exception;
	
	T obtenerPorId(ID id) throws Exception;
	
	void modificar(T entidad) throws Exception;
	
	void eliminar(T entidad) throws Exception;
	
}
