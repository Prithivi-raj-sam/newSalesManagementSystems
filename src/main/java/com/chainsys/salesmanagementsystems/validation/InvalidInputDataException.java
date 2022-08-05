package com.chainsys.salesmanagementsystems.validation;

public class InvalidInputDataException extends Exception{
	public InvalidInputDataException() {
		super("The input Data is not valid");
	}
    public InvalidInputDataException(String message) {
    	super(message);
    }

}
