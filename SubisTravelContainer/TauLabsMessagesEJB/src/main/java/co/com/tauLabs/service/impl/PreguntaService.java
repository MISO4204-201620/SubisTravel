package co.com.tauLabs.service.impl;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.logging.Logger;

import co.com.tauLabs.dao.IPreguntaDao;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Pregunta;
import co.com.tauLabs.service.IPreguntaService;

@Stateless
@Named
public class PreguntaService implements IPreguntaService,Serializable {

	final static Logger logger = Logger.getLogger(PreguntaService.class);

	private static final long serialVersionUID = 1L;

	@EJB private IPreguntaDao preguntaDao;

	public PreguntaService() {
		
    }

	@Override
	public Pregunta registrarPregunta(Pregunta pregunta) throws ServiceEJBException {
		try{
			pregunta.setFecha(new Date());
			return preguntaDao.guardar(pregunta);
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al registrar la pregunta, causa: "+e.getMessage());
		}
	}

}
