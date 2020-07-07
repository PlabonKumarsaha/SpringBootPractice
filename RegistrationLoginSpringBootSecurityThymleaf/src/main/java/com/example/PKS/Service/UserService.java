package com.example.PKS.Service;

import com.example.PKS.Model.User;
import com.example.PKS.Web.dto.UserRegistrationDTO;

public interface UserService {
	
	User save(UserRegistrationDTO registrationDTO);

}
