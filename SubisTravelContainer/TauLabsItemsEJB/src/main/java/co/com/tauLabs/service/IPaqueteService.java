package co.com.tauLabs.service;

import javax.ejb.Local;

import co.com.tauLabs.dto.PaqueteDTO;
import co.com.tauLabs.exception.ServiceEJBException;

@Local
public interface IPaqueteService {

	PaqueteDTO guardarPaquete(PaqueteDTO paquete) throws ServiceEJBException;
	
	PaqueteDTO obtenerPaquetePorIdItemPaquete(Long idItemPaquete) throws ServiceEJBException;
}
