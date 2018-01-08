package com.spring63.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring63.mvc.model.ModelLogin;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @RequestMapping(value = "/spring/login", method = RequestMethod.GET)
    public String login(Model model) {

        model.addAttribute("id", "aaa");
        return "spring/loginget";
    }

    @RequestMapping(value = "/spring/loginpost", method = RequestMethod.POST)
    public String loginpost(Model model, @RequestParam String id, @RequestParam String pw) {
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);

        return "spring/loginpost";
    }

    @RequestMapping(value = "/spring/loginmodel", method = RequestMethod.GET)
    public String loginmodel(Model model) {
        return "spring/loginmodelget";
    }

    @RequestMapping(value = "/spring/loginmodelpost", method = RequestMethod.POST)
    public String loginmodel(Model model, @ModelAttribute ModelLogin info) {
        model.addAttribute("info", info);
        return "spring/loginmodelpost";
    }

}
