package co.com.tauLabs.exception;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class PersistenceException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(PersistenceException.class);
	
	public PersistenceException(String message) {
		super(message);
		logger.error(message);
	}
}
