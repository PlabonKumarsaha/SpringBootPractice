package com.example.PKS.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.PKS.Model.User;
import com.example.PKS.Web.dto.UserRegistrationDTO;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDTO registrationDTO);

}
