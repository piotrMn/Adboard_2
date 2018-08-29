package com.universe.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public ModelAndView renderHomepage() {
		logger.info("Into renderHomepage method, searching for jsp file...");
		ModelAndView modelAndView = new ModelAndView("homepage");
		modelAndView.setStatus(HttpStatus.OK);
		return modelAndView;
	}

}
