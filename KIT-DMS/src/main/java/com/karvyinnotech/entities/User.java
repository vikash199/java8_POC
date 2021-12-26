package com.karvyinnotech.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_t")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String emilId;
	
	@Column(name = "mobile")
	private String mobileNo;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "updated_date")
	private String updatedDate;
	
	
	@OneToMany(mappedBy="users",cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private List<UserRoleMapping> userRoleMappings;
	
	
	@OneToMany(mappedBy="users",cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private List<UserProjectPermissionMapping> userProjectPermissionMapping;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmilId() {
		return emilId;
	}

	public void setEmilId(String emilId) {
		this.emilId = emilId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	

}
