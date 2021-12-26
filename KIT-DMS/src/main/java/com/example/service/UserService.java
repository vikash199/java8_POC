package com.example.service;

import com.example.dto.UserDto;
import com.example.response.LoginResponse;

public interface UserService {

	LoginResponse loginUser(UserDto userDto);
}
