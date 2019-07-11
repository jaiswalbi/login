package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dto.LoginDto;
import com.dto.SignupDto;
import com.services.SignupService;
@Controller
public class SignupController {
	
	private SignupService signupService ;
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView signup() {
		System.out.println("i am being called from signup");
		SignupDto signupDto= new SignupDto();
		ModelAndView mv= new ModelAndView("signup");
		mv.addObject("registerDtoObj",signupDto);
		return mv;
	}
	
	@RequestMapping(value="register-progress", method=RequestMethod.POST)
	public ModelAndView processSignup(SignupDto signupDto){
		signupService.register(signupDto);
		LoginDto loginDto = new LoginDto();
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("loginObj", loginDto);
		return mv;
	}

	public SignupService getSignupService() {
		return signupService;
	}

	public void setSignupService(SignupService signupService) {
		this.signupService = signupService;
	}

	
	
}
