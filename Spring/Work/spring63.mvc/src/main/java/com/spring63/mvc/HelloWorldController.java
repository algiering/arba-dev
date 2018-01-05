package com.spring63.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HelloWorldController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/spring/helloworld", method = RequestMethod.GET)
    public String helloworld(Model model) {
        logger.info("/spring/helloworld");
        
        model.addAttribute("msg", "helloworld");
        
        return "helloworld";
    }
	
	@RequestMapping(value = "/spring/sayhello", method = RequestMethod.GET)
    public ModelAndView sayhello(Model model) {
        logger.info("/spring/sayhello");
        
        model.addAttribute("msg", "helloworld");
        
        ModelAndView mv = new ModelAndView();
        
        mv.setViewName("sayhello");
        mv.addObject("msg", "Say Hello");
        
        return mv;
    }
	
	@RequestMapping(value = "/spring/redirect", method = RequestMethod.GET)
    public String redirect(Model model) {
        logger.info("/spring/redirect");
        return "redirect:/spring/helloworld";
    }
	
	@RequestMapping(value = "/spring/forward", method = RequestMethod.GET)
    public String forward(Model model) {
        logger.info("/spring/forward");
        return "forward:/spring/helloworld";
    }
	
	@RequestMapping(value = "/spring/querystring", method = RequestMethod.GET)
    public String querystring(Model model, HttpServletRequest request) {
        logger.info("/spring/querystring");
        
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        
        return "querystring";
    }
	
	@RequestMapping(value = "/spring/querystring2", method = RequestMethod.GET)
    public String querystring2(Model model, @RequestParam(value="name", defaultValue="") String name, @RequestParam(value="phone", defaultValue="0") int phone) {
        logger.info("/spring/querystring2");
        
        name = "name";
        phone = 300;
        
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        
        return "querystring";
    }
	
	@RequestMapping(value = "/spring/pathvalue/{name}", method = RequestMethod.GET)
    public String pathvalue(Model model, @RequestParam( value="name", defaultValue="") String name) {
        logger.info("/spring/pathvalue");
        
        model.addAttribute("name", name);
        
        return "querystring";
    }
	
}
