package com.bit.daNaOutlet;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ShowController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShowController.class);
	
	
	@RequestMapping(value = "/main/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	@RequestMapping(value="/main/join",method = RequestMethod.GET)
	public String join() {
		
		return "join";
	}
	
	
	@RequestMapping(value="/main/login")
	public String login() {
		
		return "login";
	}
	
	
	@RequestMapping(value="/member/list", method=RequestMethod.GET)
	public String memberList(@PathVariable String path) {
		
		return "list";
	}
}
