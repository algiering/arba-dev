package com.web.juha.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.juha.inf.IServiceUser;
import com.web.juha.model.ModelUser;

@Controller
public class UserController {
    
    @Autowired
    IServiceUser svr_user;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
	    
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model
            , RedirectAttributes rttr
            , @RequestParam(defaultValue="") String user_id
            , @RequestParam(defaultValue="") String user_password) {
        
        return "login";
    }
	
	@RequestMapping(value = "/login_ok", method = RequestMethod.POST)
    public String login_ok(Model model
            , @RequestParam String user_id
            , @RequestParam String user_password
            , RedirectAttributes rttr) {
	    
	    ModelUser user = new ModelUser();
	    user.setUser_id(user_id);
	    user.setUser_password(user_password);
	    
	    int result = svr_user.Login(user);
	    
	    if (result == 0) {
	        rttr.addFlashAttribute("msg", WebConstant.MSG_LOGIN_FAILED);
            return "redirect:/login";
	    }
	    else if (result == -1) {
	        rttr.addAttribute("msg", WebConstant.MSG_SERVER_FAILED);
            return "redirect:/login";
	    }
	    else {
	        return "redirect:/article?article_subno=1&board_id=0"; // TODO 메인으로 가도록 수정
	    }
    }
	
}
