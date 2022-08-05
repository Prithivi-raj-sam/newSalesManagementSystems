package com.chainsys.salesmanagementsystems.validation;


public class Validator {
	public static void nullValueErrorCheck(Object object) throws InvalidInputDataException{
		if(object.equals(null)) {
			throw new InvalidInputDataException("value is null");
		}
	}
}
