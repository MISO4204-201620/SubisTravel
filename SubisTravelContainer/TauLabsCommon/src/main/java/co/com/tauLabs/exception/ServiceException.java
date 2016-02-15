package co.com.tauLabs.exception;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class ServiceException extends Exception implements Serializable  {
	
private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(ServiceException.class);
	
	public ServiceException(String message) {
		super(message);
		logger.error(message);
	}
	
}
