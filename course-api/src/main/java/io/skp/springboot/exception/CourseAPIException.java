package io.skp.springboot.exception;

public class CourseAPIException extends Exception{

	public CourseAPIException(String errorMessage) {
		super(errorMessage);
	}
	
}
