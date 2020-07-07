package com.example.PKS.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PKS.Model.Role;
import com.example.PKS.Model.User;
import com.example.PKS.Repository.UserRepository;
import com.example.PKS.Web.dto.UserRegistrationDTO;


@Service
public class UserServiceImpl implements UserService  {
	
	@Autowired
	private UserRepository userRepository;
	
	
	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}




	@Override
	public User save(UserRegistrationDTO registrationDTO) {
		// TODO Auto-generated method stub
		
		User user = new User(registrationDTO.getFirstName(),registrationDTO.getLastName(),registrationDTO.getEmail(),registrationDTO.getPassword(),
				Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

	

}
