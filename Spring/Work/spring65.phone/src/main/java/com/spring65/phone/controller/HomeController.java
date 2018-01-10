package com.spring65.phone.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring65.phone.inf.IServicePhone;
import com.spring65.phone.model.ModelPhone;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	IServicePhone service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/writeonemain", method = RequestMethod.GET)
    public String writeonemain(Model model) {
        
        return "writeOneMain";
    }
	
	@RequestMapping(value = "/writeone1", method = RequestMethod.POST)
    public String writeone1(Model model, HttpServletRequest request) {

	    String name = request.getParameter("name");
	    String manufacturer = request.getParameter("manufacturer");
	    String temp = request.getParameter("price");
	    
	    int price = Integer.valueOf(temp.isEmpty() ? "0" : temp);
	    
	    ModelPhone phone = new ModelPhone();
	    
	    phone.setName(name);
	    phone.setManufacturer(manufacturer);
	    phone.setPrice(price);
	    
	    service.insertPhone(phone);
	    
	    model.addAttribute("phone", phone);
        
        return "writeOneResult";
    }
	
	@RequestMapping(value = "/writeone2", method = RequestMethod.POST)
    public String writeone2(Model model, @RequestParam(value="name") String name, @RequestParam (value="manufacturer") String manufacturer, @RequestParam (value="price", defaultValue="0") Integer price) {
        
	    ModelPhone phone = new ModelPhone(name, manufacturer, price);
	    
	    service.insertPhone(phone);
	    
	    model.addAttribute("phone", phone);
	    
        return "writeOneResult";
    }
	
	@RequestMapping(value = "/writeone3", method = RequestMethod.POST)
    public String writeone3(Model model, @ModelAttribute ModelPhone phone) {
	    
	    service.insertPhone(phone);
	    
	    model.addAttribute("phone", phone);
        
        return "writeOneResult";
    }
	
	@RequestMapping(value = "/writelist", method = RequestMethod.GET)
    public String writelist(Model model) {
        
        return "writeList";
    }
	
	@RequestMapping(value = "/writelistresult", method = RequestMethod.POST)
    public String writelistresult(Model model, @ModelAttribute RepositoryPhone phones) {
	    
	    List<ModelPhone> list = phones.getPhoneItems();
	    
	    service.insertPhoneList(list);
	    
	    list = service.getPhoneList();
	    
	    model.addAttribute("list", list);
	    
	    
	    
        return "writeListResult";
    }
	
	
	@RequestMapping(value = "/writeoneresult", method = RequestMethod.GET)
    public String writeoneresult(Model model, @RequestParam String name, @RequestParam String manufacturer, @RequestParam int price) {
	    
	    ModelPhone phone = new ModelPhone();
	    phone.setName(name);
	    phone.setManufacturer(manufacturer);
	    phone.setPrice(price);
	    
	    model.addAttribute("phone",phone);
	    
        return "writeOneResult";
    }
	
}
