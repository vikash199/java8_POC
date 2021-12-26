package com.karvyinnotech.service;

import com.karvyinnotech.dto.UserDto;
import com.karvyinnotech.response.LoginResponse;

public interface UserService {

	LoginResponse loginUser(UserDto userDto);
}
