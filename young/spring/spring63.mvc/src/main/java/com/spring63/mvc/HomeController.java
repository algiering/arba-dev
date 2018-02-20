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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriTemplate;

import com.spring63.mvc.ModelLogin;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home! The client locale is {}.");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

    @RequestMapping(value = "/spring/helloworld", method = RequestMethod.GET)
    public String helloworld(Model model) {
        logger.info("/spring/helloworld");             
        model.addAttribute("msg", "Hello, Wordl!!!"  );        
        return "spring/helloworld";
    }

    @RequestMapping(value = "/spring/sayhello", method = RequestMethod.GET)
    public ModelAndView sayhello(Model model) {
        logger.info("/spring/sayhello");             
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sayhello"); // View 이름
        mv.addObject("msg", "Hello, Wordl!!!"); // 데이터 : Model 정보
        
        return mv;
    }
        
    // redirect 테스트
    @RequestMapping(value = "/spring/redirect", method = RequestMethod.GET)
    public String redirect(Model model) {        
        return "redirect:/spring/helloworld";        
    }
    
    // forward 테스트
    @RequestMapping(value = "/spring/forward", method = RequestMethod.GET)
    public String forward(Model model) {          
        return "forward:/spring/helloworld";        
    }

    // QueryString 테스트 >> @RequestParam 테스트
    @RequestMapping(value = "/spring/querystring", method = RequestMethod.GET)
    public String querystring(Model model, HttpServletRequest request) {          
        String name  = request.getParameter("name");
        String price = request.getParameter("price");
        
        model.addAttribute("name", name);
        model.addAttribute("price", price);
                
        return "spring/querystring";
    }
    
    // QueryString 테스트 >> @PathVariable 테스트
    @RequestMapping(value = "/spring/querystring2", method = RequestMethod.GET)
    public String querystring2(Model model
                              , @RequestParam( value="name" , defaultValue=""  ) String name
                              , @RequestParam( value="price", defaultValue="0" ) int price   ) {          
               
        model.addAttribute("name", name);
        model.addAttribute("price", price);
                
        return "spring/querystring";
    }

    @RequestMapping(value = "/spring/querypath/{name}", method = RequestMethod.GET)
    public String querypath(Model model
                           , @PathVariable(value="name") String name ) {          
               
        model.addAttribute("name", name);
                
        return "spring/querystring";
    }
    
    // QueryString 테스트 >> @PathVariable 테스트
    /*
    ?  - zero or one charecter
    *  - one charecter
    ** - one or more charecters
    */
    @RequestMapping(value = "/spring/querypath/{name}/**", method = RequestMethod.GET)
    public ModelAndView querypath(
            Model model,
            @PathVariable(value="name") String name,  
            HttpServletRequest request ) {     
        logger.info("HomeController.querypath");
        
        String phone = null;
        
        String restOfUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
     
        UriTemplate template = new UriTemplate("/spring/querypath/{name}/{phone}");        
        boolean isTemplateMatched = template.matches(restOfUrl);
        if(isTemplateMatched) {
            Map<String, String> matchTemplate = new HashMap<String, String>();
            matchTemplate = template.match(restOfUrl);
            phone = matchTemplate.get("phone");
        }
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("name" , name  );
        map.put("phone", phone );
        
        return new ModelAndView("home/pathvalue", map) ;       
    }
           
    // login 테스트
    @RequestMapping(value = "/spring/login", method = RequestMethod.GET)
    public String login( Model model) {
        model.addAttribute("id", "aaa");
        
        return "spring/loginget";
    }
    
    // login 테스트
    @RequestMapping(value = "/spring/login", method = RequestMethod.POST)
    public String login( Model model
            , @RequestParam(value="id") String id
            , @RequestParam(value="pw") String pw) {

        // DB 조회.
        
        // 결과 리턴: 성공여부 리턴
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        
        return "spring/loginpost";
    }
    

    
    // login 테스트
    @RequestMapping(value = "/spring/loginmodel", method = RequestMethod.GET)
    public String loginmodel( Model model) {
        model.addAttribute("id", "aaa");
        
        return "spring/loginmodelget";
    }
    // login 테스트
    @RequestMapping(value = "/spring/loginmodel", method = RequestMethod.POST)
    public String loginmodel( Model model
            , @ModelAttribute ModelLogin login ) {
        // DB 조회 : 생략
        
        // 결과 출력
        model.addAttribute("login", login);
        
        return "spring/loginmodelpost";
    }

}
