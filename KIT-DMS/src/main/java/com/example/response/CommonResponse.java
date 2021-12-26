package com.example.response;

public class CommonResponse extends RestResponse{
	
	private boolean forceUpdateRequired;

	public boolean isForceUpdateRequired() {
		return forceUpdateRequired;
	}

	public void setForceUpdateRequired(boolean forceUpdateRequired) {
		this.forceUpdateRequired = forceUpdateRequired;
	}

}
