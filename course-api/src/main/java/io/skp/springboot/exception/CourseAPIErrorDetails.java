package io.skp.springboot.exception;

public class CourseAPIErrorDetails {
	private String errorCode;
	private String errorDescription;
	
	
	public String getErrorCode() {
		return errorCode;
	}


	public String getErrorDescription() {
		return errorDescription;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}


	public CourseAPIErrorDetails(String errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

}
