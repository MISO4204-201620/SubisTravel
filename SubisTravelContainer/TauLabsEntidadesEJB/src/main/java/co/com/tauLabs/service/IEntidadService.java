package co.com.tauLabs.service;

import javax.ejb.Local;

import co.com.tauLabs.model.Entidad;

@Local
public interface IEntidadService extends IGenericService<Entidad, Long> {

}
