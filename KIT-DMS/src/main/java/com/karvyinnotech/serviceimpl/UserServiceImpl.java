package com.karvyinnotech.serviceimpl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karvyinnotech.dto.UserDto;
import com.karvyinnotech.entities.User;
import com.karvyinnotech.repository.UserRepository;
import com.karvyinnotech.repository.UserRoleRepository;
import com.karvyinnotech.response.LoginResponse;
import com.karvyinnotech.service.UserService;
import com.karvyinnotech.util.ConstantsApi;
import com.karvyinnotech.util.ConvertStringToMD5;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserRoleRepository userRoleRepo;

	@Override
	public LoginResponse loginUser(UserDto userDto) {

		
		
		LoginResponse response = new LoginResponse();
		
		try {
			
			ConvertStringToMD5 convertStringToMD5 = new ConvertStringToMD5();
			String userPassword = convertStringToMD5.convertStringToMd5(userDto.getPassword());
			
			User userDetails = userRepo.findByEmilId(userDto.getEmail());
			
			if(userDetails == null) {
				
				response.setStatus(ConstantsApi.API_FAIL_STATUS);
				response.setMessage("Invalid user credentials");
				response.setResponseCode(HttpServletResponse.SC_NOT_FOUND);
				
			} else if(!userDetails.getPassword().equalsIgnoreCase(userPassword)) { 
				
				response.setStatus(ConstantsApi.API_FAIL_STATUS);
				response.setMessage("Invalid credentials");
				response.setResponseCode(HttpServletResponse.SC_NOT_FOUND);
				
			}else if(userDetails.getStatus()==false) { 
				
				response.setStatus(ConstantsApi.API_FAIL_STATUS);
				response.setMessage("User is Deactivated");
				response.setResponseCode(HttpServletResponse.SC_NOT_FOUND);
				
			}else{
				
				
				
				response.setUserId(userDetails.getUserId());
				response.setUserName(userDetails.getName());
				response.setEmailId(userDetails.getEmilId());
				response.setMobileNo(userDetails.getMobileNo());
				response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
				response.setMessage("Logged in successfully");
				response.setResponseCode(HttpServletResponse.SC_OK);
			} 
			
		} catch(Exception e) {
			e.printStackTrace();
			response.setStatus(ConstantsApi.API_FAIL_STATUS);
			response.setMessage(e.getMessage());
			response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	

}
