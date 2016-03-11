package co.com.tauLabs.dao.impl;

import java.io.Serializable;

import javax.ejb.Stateless;

import co.com.tauLabs.dao.IPreguntaDao;
import co.com.tauLabs.model.Pregunta;

@Stateless
public class PreguntaDao extends GenericDao<Pregunta, Long>  implements IPreguntaDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public PreguntaDao() {

    }

}
