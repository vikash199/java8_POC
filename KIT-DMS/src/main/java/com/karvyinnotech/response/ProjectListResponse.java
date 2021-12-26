package com.karvyinnotech.response;

import java.util.List;

public class ProjectListResponse extends RestResponse{
	
	private List<ProjectResponse> projectListResponse;

	public List<ProjectResponse> getProjectListResponse() {
		return projectListResponse;
	}

	public void setProjectListResponse(List<ProjectResponse> projectListResponse) {
		this.projectListResponse = projectListResponse;
	}
	
	
	

}
