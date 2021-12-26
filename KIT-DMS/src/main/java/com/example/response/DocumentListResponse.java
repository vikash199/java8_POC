package com.example.response;

import java.util.List;

public class DocumentListResponse extends RestResponse{
	
	List<DocumentResponse> documentlistResponse;

	public List<DocumentResponse> getDocumentlistResponse() {
		return documentlistResponse;
	}

	public void setDocumentlistResponse(List<DocumentResponse> documentlistResponse) {
		this.documentlistResponse = documentlistResponse;
	}
	
	
	

}
