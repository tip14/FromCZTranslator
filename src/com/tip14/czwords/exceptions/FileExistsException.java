package com.tip14.czwords.exceptions;

public class FileExistsException extends AppException{
	public FileExistsException(){
		super("File With Words To Translate doesn't exist!");
	}
}
