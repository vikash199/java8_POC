package com.example.response;

public abstract class RestResponse {
	
	private String status;
	private String message;
	private Integer responseCode;
	
	public RestResponse(){}
    public RestResponse(String status, String message){
        this.status = status;
        this.message = message;
    }
    
    public RestResponse(String status, String message, Object data){
        this.status = status;
        this.message = message;
       
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	
}
