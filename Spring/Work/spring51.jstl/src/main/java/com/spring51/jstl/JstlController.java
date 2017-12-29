package com.spring51.jstl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class JstlController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/jstl/jstl01", method = RequestMethod.GET)
	public String jstl01(Locale locale, Model model) {
	    logger.info("jstl01");
	    
		return "jstl/jstl01"; // --> views / jstl / jstl01.jsp
	}
	
	@RequestMapping(value = "/jstl/jstl02", method = RequestMethod.GET)
    public String jstl02(Locale locale, Model model) {
        logger.info("jstl02");
        
        int num1 = 7;
        int num2 = 9;
        
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        
        return "jstl/jstl02"; // --> views / jstl / jstl02.jsp
    }
}
