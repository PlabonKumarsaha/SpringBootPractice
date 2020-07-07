package com.example.PKS.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.PKS.Service.UserService;
import com.example.PKS.Web.dto.UserRegistrationDTO;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	 @GetMapping
	    public String showRegistrationForm(Model model) {
	        return "registration";
	    }
	 
	 
	 @PostMapping
	public String registerUsingAccount(@ModelAttribute("User") UserRegistrationDTO userRegistrationDTO) {
		
		userService.save(userRegistrationDTO);
		return "redirect:/registration?success";
		
	}
}
