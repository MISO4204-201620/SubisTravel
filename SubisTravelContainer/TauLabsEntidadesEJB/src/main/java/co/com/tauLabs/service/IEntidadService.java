package co.com.tauLabs.service;

import java.util.List;

import javax.ejb.Local;

import co.com.tauLabs.model.Entidad;

@Local
public interface IEntidadService extends IGenericService<Entidad, Long> {
	List<Entidad> obtenerEntidadesPorTipo(Long idTipo) throws Exception;
}
