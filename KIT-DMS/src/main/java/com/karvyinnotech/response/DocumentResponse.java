package com.karvyinnotech.response;

public class DocumentResponse extends RestResponse{
	
	private Integer sNo;
	private Integer documentNo;
	private String documentName;
	private String documentLocation;
	private String updatedDate;
	private String createdDate;
	
	
	
	
	public Integer getsNo() {
		return sNo;
	}
	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(Integer documentNo) {
		this.documentNo = documentNo;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentLocation() {
		return documentLocation;
	}
	public void setDocumentLocation(String documentLocation) {
		this.documentLocation = documentLocation;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	

}
