package com.web2.juha.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web2.juha.common.WebConstants;
import com.web2.juha.model.ModelUser;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // @RequestMapping(value = "/", method = RequestMethod.GET)
    // public String home(Model model) {
    // logger.info("");
    //
    // return "home";
    // }

    // 로그인 페이지
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(Model model
            , HttpSession session) {
        logger.info("User > Login(GET)");
        
        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        
        if(user != null) {
            return "/articlelist/mhw/page=1";
        }

        return "login";
    }

}
