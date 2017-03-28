package com.tip14.czwords.exceptions;

public class InvalidFilePathException extends AppException{

	public InvalidFilePathException() {
		super("It's directory, i need a file!");
	}
}
