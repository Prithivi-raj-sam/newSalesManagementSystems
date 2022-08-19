package com.chainsys.salesmanagementsystems.validation;

public class InvalidInputDataException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1693585663369357017L;
	public InvalidInputDataException() {
		super("The input Data is not valid");
	}
    public InvalidInputDataException(String message) {
    	super(message);
    }

}
