package com.project.SportyShoes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.SportyShoes.entity.UserDetails;
import com.project.SportyShoes.service.UserDetailsService;

@Controller
public class UserDetailsController {
	@Autowired
	UserDetailsService userservice;
	
	
	
	@GetMapping("/index")
	public String viewUserDetails(Model model)
	{
		List<UserDetails> listUsers= userservice.listAll();
		System.out.println("listUsers" + listUsers);
		model.addAttribute("listUsers",listUsers);
		return "/index";
	}
	
	
	@GetMapping("/user/{username}")
	public String findUserName(@PathVariable(name="username")String username)
	{	
		System.out.println("i am here");
		ModelAndView mav = new ModelAndView("find");
		List<UserDetails> userdetails=userservice.get(username);
		mav.addObject("userdetails", userdetails);
		return "finduser";
	}
	
	
	
	

}
