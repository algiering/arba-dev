package com.exam09.juha.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam09.juha.inf.IServicePhone;
import com.exam09.juha.model.ModelPhone;

@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	IServicePhone svr_phone;
	
	@RequestMapping(value = "/phone/writeone", method = RequestMethod.GET)
	public String writeone(Model model) {
		logger.info("");
		
		return "writeOneForm";
	}
	
	@RequestMapping(value = "/phone/writeone", method = RequestMethod.POST)
    public String writeone(Model model
            , @RequestParam String phname
            , @RequestParam String phfactory
            , @RequestParam Integer phprice) {
        logger.info("");
        
        ModelPhone phone = new ModelPhone();
        
        phone.setName(phname);
        phone.setManufacturer(phfactory);
        phone.setPrice(phprice);
        
        int result = -1;
        result = svr_phone.insertPhone(phone);
        
        return "redirect:/phone/writeonelist";
    }
	
	@RequestMapping(value = "/phone/writeonelist", method = RequestMethod.GET)
    public String writeonelist(Model model) {
        logger.info("");
        
        List<ModelPhone> phone = svr_phone.getPhoneList();
        
        model.addAttribute("phone", phone);
        
        return "writeOneResult";
    }
	
}
