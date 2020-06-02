package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;;


@Controller
public class ControllerClass {
	
	
//first URL is for home and 2nd is for hello 
	
	@GetMapping({"/","/hello"})
	public String hello(@RequestParam(value ="name",defaultValue ="spring boot",required= true)
			String name,Model model) {
		//add key value pair
		model.addAttribute("name",name);
		
				return "hello";
		
		
	}
}
