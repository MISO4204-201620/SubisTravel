package co.com.tauLabs.dao.impl;

import java.io.Serializable;


import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.tauLabs.dao.IConsultaDao;
import co.com.tauLabs.model.Consulta;


@Stateless
@Named
public class ConsultaDao extends GenericDao<Consulta, Long>  implements IConsultaDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public ConsultaDao() {

    }
    @PersistenceContext(unitName = "TauLabsEntidadesEJB")
	EntityManager em;
    
	
}
