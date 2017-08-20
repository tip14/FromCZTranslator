package com.tip14.czwords.exceptions;

import com.tip14.czwords.main.Initializer;

public class AppException extends Exception{
	String message;
	
	AppException(String message){
		this.message = message;
	}
	
	public void tryAgain(){
		Initializer i = new Initializer();
		i.initMenu();
		
	}
	
	
}
