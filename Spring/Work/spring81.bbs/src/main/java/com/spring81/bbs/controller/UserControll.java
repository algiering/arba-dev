package com.spring81.bbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring81.bbs.common.WebConstants;
import com.spring81.bbs.inf.IServiceUser;
import com.spring81.bbs.model.ModelUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserControll {

    private static final Logger logger = LoggerFactory.getLogger(UserControll.class);

    @Autowired
    IServiceUser svruser;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public String user(Model model) {
        logger.info("/user/");

        return "redirect:/user/login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login(Model model, @RequestParam(defaultValue = "") String url, HttpServletRequest request) {
        logger.info("/user/login : get");

        if (url.isEmpty()) {
            url = request.getHeader("Refer");
        }

        model.addAttribute("url", url);

        return "user/login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String url, @RequestParam String userid, @RequestParam String passwd,
            HttpSession session, RedirectAttributes rttr) {
        logger.info("/user/login : post");

        ModelUser result = svruser.login(userid, passwd);

        if (result != null) {
            // Login success
            session.setAttribute(WebConstants.SESSION_NAME, result);

            if (url.isEmpty()) {
                return "redirect:/";
            } else {
                return "redirect:" + url;
            }
        }

        else {
            // redirect시 사용되는 변수
            rttr.addFlashAttribute("msg", "로그인 실패");
            rttr.addFlashAttribute("url", url);
            return "redirect:/user/login";
        }
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session) {
        logger.info("/user/logout");

        session.removeAttribute(WebConstants.SESSION_NAME);

        return "redirect:/";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String register(Model model) {
        logger.info("/user/");

        return "user/register";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute ModelUser user) {
        logger.info("/user/");

        int result = svruser.insertUser(user);

        return "user/register_post";
    }

    @RequestMapping(value = "/user/usermodify", method = RequestMethod.GET)
    public String usermodify(Model model, HttpSession session) {
        logger.info("/user/");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);

        user = svruser.selectUserOne(user);

        if (user == null) {
            return "redirect:/user/login";
        }

        model.addAttribute("user", user);

        return "/user/usermodify";
    }

    @RequestMapping(value = "/user/usermodify", method = RequestMethod.POST)
    public String usermodify(Model model, @ModelAttribute ModelUser setValue, HttpSession session,
            RedirectAttributes rttr) {
        logger.info("/user/");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);

        if (user == null) {
            throw new RuntimeException(WebConstants.LOGIN_FAILED);
        }

        ModelUser whereValue = new ModelUser();
        whereValue.setUserid(user.getUserid());
        whereValue.setPasswd(setValue.getPasswd());

        user = svruser.selectUserOne(user);
        if (svruser.checkpassword(setValue.getUserid(), setValue.getPasswd()) == 0) {
            throw new RuntimeException(WebConstants.ERROR_PASSWORD);
        }

        int result = svruser.updateUserInfo(setValue, whereValue);

        if (result > 0) {
            svruser.selectUserOne(user);
            session.setAttribute(WebConstants.SESSION_NAME, user);

            return "/user/changepassword";
        } else {
            rttr.addFlashAttribute("user", setValue);
            rttr.addFlashAttribute("msg", WebConstants.UPDATE_FAILED);
            return "redirect:/user/usermodify";
        }
    }
    
    @RequestMapping(value = "/user/changepassword", method = RequestMethod.GET)
    public String user(Model model, HttpSession session) {
        logger.info("/user/");
        
        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        
        if(user == null) {
            return "redirect:/user/login";
        }
        else {
            return "/user/changepassword";
        }
    }

    @RequestMapping(value = "/user/changepassword", method = RequestMethod.POST)
    public String changepassword(Model model, @RequestParam String currentPasswd, @RequestParam String newPasswd,
            HttpSession session, RedirectAttributes rttr) {
        logger.info("/user/changepassword");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);

        int result = svruser.updatePasswd(user.getUserid(), currentPasswd, newPasswd);

        if (result == 1) {
            return "/user/changepassword_post";
        } else {
            rttr.addFlashAttribute("msg", WebConstants.MSG_CHANGE_FAILED);
            return "redirect:/user/changepassword";
        }
    }
    
    @RequestMapping(value = "/user/unregister", method = RequestMethod.GET)
    public String unregister(Model model) {
        logger.info("/user/unregister : get");

        return "/user/unregister";
    }
    
    @RequestMapping(value = "/user/unregister", method = RequestMethod.POST)
    public String unregister(Model model, @RequestParam String email, @RequestParam String passwd, HttpSession session) {
        logger.info("/user/unregister: post");
        
        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        user.setEmail(email);
        user.setPasswd(passwd);
        
        int result = svruser.updateRetire(user);
        
        if (result == 1) {
            session.removeAttribute(WebConstants.SESSION_NAME);
            return "/user/unregister_post";
        }
        else {
            return "/user/unreegister";
        }
    }

}
