package co.com.tauLabs.exception;

import javax.ejb.ApplicationException;

import org.apache.log4j.Logger;

@ApplicationException(rollback=true)
public class PersistenceEJBException extends RuntimeException  {

	final static Logger logger = Logger.getLogger(PersistenceEJBException.class);

	private static final long serialVersionUID = 1L; 
	
	public PersistenceEJBException(){
		
	}
	
	public PersistenceEJBException(String message){
		super(message);
		System.out.println(message);
		logger.error(message);
	}
	
}
