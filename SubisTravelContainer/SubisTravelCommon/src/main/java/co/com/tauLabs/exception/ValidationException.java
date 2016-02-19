package co.com.tauLabs.exception;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class ValidationException extends Exception implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	final static Logger logger = Logger.getLogger(ValidationException.class);

	public ValidationException(String message) {
		super(message);
	}
}
