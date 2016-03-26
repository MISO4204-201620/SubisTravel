package co.com.tauLabs.exception;

import javax.ejb.ApplicationException;

import org.apache.log4j.Logger;

@ApplicationException(rollback = true)
public class ServiceEJBException extends RuntimeException {

	final static Logger logger = Logger.getLogger(ServiceEJBException.class);

	private static final long serialVersionUID = 1L;

	public ServiceEJBException() {

	}

	public ServiceEJBException(String message) {
		super(message);
		System.out.println(message);
		logger.error(message);
	}

}
