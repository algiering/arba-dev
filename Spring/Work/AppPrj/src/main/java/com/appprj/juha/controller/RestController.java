package com.appprj.juha.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appprj.juha.inf.IServiceArticle;
import com.appprj.juha.inf.IServiceUser;
import com.appprj.juha.model.ModelArticle;

@Controller
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    IServiceUser svr_user;

    @Autowired
    IServiceArticle svr_article;

    // 베이직 폼
    // @RequestMapping(value = "/", method = RequestMethod.GET)
    // @ResponseBody
    // public String home() {
    // logger.info("");
    //
    // return "";
    // }

    // 로그인
    @RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public int Login(Model model, @RequestParam String user_id, @RequestParam String user_pw) {
        logger.info("Rest > Login (POST, GET)");

        int result = -2;

        result = svr_user.getLogin(user_id, user_pw);

        return result;
    }

    // 전체 리스트
    @RequestMapping(value = "/getarticlelist", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public List<ModelArticle> GetArticleList() {
        logger.info("Rest > GetArticleList (POST, GET)");
        
        List<ModelArticle> result = svr_article.getArticleList("mhw");

        return result;
    }

}
