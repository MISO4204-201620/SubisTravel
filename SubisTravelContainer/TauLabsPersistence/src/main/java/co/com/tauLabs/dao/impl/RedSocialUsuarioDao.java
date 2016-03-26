package co.com.tauLabs.dao.impl;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.tauLabs.dao.IRedSocialUsuarioDao;
import co.com.tauLabs.model.RedSocialUsuario;

@Stateless
@Named
public class RedSocialUsuarioDao extends GenericDao<RedSocialUsuario, Long>  implements IRedSocialUsuarioDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public RedSocialUsuarioDao() {

    }
 
    @PersistenceContext(unitName = "TauLabsEntidadesEJB")
	EntityManager em;
 
}
