/**
 * 
 */
package com.progressoft.induction;

/**
 * @author PSLPT 147
 *
 */
public class ProcessException extends Exception {

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ProcessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ProcessException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ProcessException(Throwable cause) {
		super(cause);
	}

}
