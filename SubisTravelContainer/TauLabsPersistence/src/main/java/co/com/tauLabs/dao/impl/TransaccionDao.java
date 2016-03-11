package co.com.tauLabs.dao.impl;

import java.io.Serializable;

import javax.ejb.Stateless;

import co.com.tauLabs.dao.ITransaccionDao;
import co.com.tauLabs.model.Transaccion;

@Stateless
public class TransaccionDao extends GenericDao<Transaccion, Long>  implements ITransaccionDao, Serializable{
	
	private static final long serialVersionUID = 554771308104758587L;
	
    public TransaccionDao() {

    }

}
