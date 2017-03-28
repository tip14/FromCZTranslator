package com.tip14.czwords.exceptions;

public class BackslashInPathException extends AppException {

	public BackslashInPathException() {
		super("Please, use only slashes in path");
	}
}
