package com.exam8.juha;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JHController {
	
	private static final Logger logger = LoggerFactory.getLogger(JHController.class);
	
	// http://localhost/jstl/jstl11
	// http://localhost/jstl/jstl11?val=0
	@RequestMapping(value = "/jstl/jstl11", method = RequestMethod.GET)
	public String jstl11(Model model, @RequestParam(defaultValue="-1") Integer val)  {
		logger.info("jstl11");
		
		model.addAttribute("val", val);
		
		return "jstl11";
	}
	
	// http://localhost/jstl/jstlforeach
    @RequestMapping(value = "/jstl/jstlforeach", method = RequestMethod.GET)
    public String jstlforeach(Model model)  {
        logger.info("jstlforeach");
        
        List<String> list = new ArrayList<>();
        list.add("순두부");
        list.add("된장찌개");
        list.add("제육덮밥");
        
        String[] array = {"순두부", "된장찌개", "제육덮밥"};
        
        model.addAttribute("list", array);
        
        return "jstlforeach";
    }
	
}
