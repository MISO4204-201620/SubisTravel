package co.com.tauLabs.dao.impl;

import java.io.Serializable;


import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.tauLabs.dao.IMensajeDao;
import co.com.tauLabs.model.Mensaje;


@Stateless
@Named
public class MensajeDao extends GenericDao<Mensaje, Long>  implements IMensajeDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public MensajeDao() {

    }
    @PersistenceContext(unitName = "TauLabsEntidadesEJB")
	EntityManager em;
    
	
}
