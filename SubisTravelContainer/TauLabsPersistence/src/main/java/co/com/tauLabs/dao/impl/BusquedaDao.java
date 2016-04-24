package co.com.tauLabs.dao.impl;

import java.io.Serializable;


import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.tauLabs.dao.IBusquedaDao;
import co.com.tauLabs.model.Busqueda;



@Stateless
@Named
public class BusquedaDao extends GenericDao<Busqueda, Long>  implements IBusquedaDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public BusquedaDao() {

    }
    @PersistenceContext(unitName = "TauLabsEntidadesEJB")
	EntityManager em;
    
	
}
