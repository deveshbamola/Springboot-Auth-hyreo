package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Service.ILoginImpl;

@Controller
public class LocalController {
	@Autowired
	ILoginImpl iLoginImpl;

	@RequestMapping("/")
	public ModelAndView model(HttpSession httpSession) {
		return new ModelAndView("login");
		
	}

	@RequestMapping("/signIn")
	public ModelAndView signIn(@RequestParam("email") String email, @RequestParam("pass") String pass) {
		ModelAndView modelAndView = new ModelAndView();
		boolean b = iLoginImpl.validate(email, pass);
		if (b) {
			modelAndView.addObject("message", "you aree logged In!");

		} else {
			modelAndView.addObject("message", "Invalid credentials");

		}
		modelAndView.setViewName("Index");
		return modelAndView;
	}
}
