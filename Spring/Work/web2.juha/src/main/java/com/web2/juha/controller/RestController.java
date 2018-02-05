package com.web2.juha.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web2.juha.common.WebConstants;
import com.web2.juha.inf.IServiceUser;
import com.web2.juha.model.ModelUser;

@Controller
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    IServiceUser svr_user;

    // 베이직 폼
    // @RequestMapping(value = "/", method = RequestMethod.GET)
    // public String home(Model model) {
    // logger.info("");
    //
    // return "home";
    // }

    // 로그인
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public int Login(Model model
            , @RequestBody ModelUser user
            , HttpSession session) {
        logger.info("Rest > Login(POST)");

        int result = -2;

        user = svr_user.getUserOne(user);

        if (user != null) {
            session.setAttribute(WebConstants.SESSION_NAME, user);
            return 1;
        }
        
        else {
            return result;
        }
    }
}
