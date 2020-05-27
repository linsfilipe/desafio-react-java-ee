package com.github.linsfilipe.domains.dtos;

public class ResponseErrorDTO extends BaseDTO {

	private static final long serialVersionUID = -5538968736719924296L;
	
	private Integer status;
    private String errorMessage;
    
    public ResponseErrorDTO(Integer status, String errorMessage) {
    	this.status = status;
		this.errorMessage = errorMessage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
}
