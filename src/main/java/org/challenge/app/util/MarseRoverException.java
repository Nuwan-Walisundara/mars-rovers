package org.challenge.app.util;

public class MarseRoverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5301460179718713878L;

	public MarseRoverException(ERROR error){
		super(error.toString());
	}
	
}
