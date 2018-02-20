package com.appprj.juha.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appprj.juha.common.AndroidPushNotificationsService;
import com.appprj.juha.inf.IServiceArticle;
import com.appprj.juha.inf.IServiceUser;
import com.appprj.juha.model.ModelArticle;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Controller
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    IServiceUser svr_user;

    @Autowired
    IServiceArticle svr_article;
    
    @Autowired
    AndroidPushNotificationsService androidPushNotificationsService;
    
    
    private final String TOPIC = "JavaSampleApproach";

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

    // 전체 리스트 & 페이징
    @RequestMapping(value = "/getarticlepaging", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String GetArticlePaging(@RequestParam String board_id, @RequestParam Integer start,
            @RequestParam Integer end) {
        logger.info("Rest > GetArticlePaging (POST, GET)");

        List<ModelArticle> result = svr_article.getArticlePaging(board_id, start, end);
        
        String json = new Gson().toJson(result);

        return json;
    }

    // 글 하나
    @RequestMapping(value = "/getarticleone", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String GetArticleOne(@RequestParam String board_id, @RequestParam int article_no) {
        logger.info("Rest > GetArticleOne (POST, GET)");

        ModelArticle result = svr_article.getArticleOne(board_id, article_no);
        
        String json = new Gson().toJson(result);

        return json;
    }

    // 글쓰기
    @RequestMapping(value = "/writearticle", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public int WriteArticle(@RequestParam String article_title, @RequestParam String article_content,
            @RequestParam String board_id) {
        logger.info("Rest > WriteArticle (POST, GET)");

        int result = svr_article.insertArticle(article_title, article_content, board_id);
        
        if (result == 1) {
            JSONObject body = new JSONObject();
            body.put("to", "/topics/" + TOPIC);
            body.put("priority", "high");

            JSONObject notification = new JSONObject();
            notification.put("title", "JSA Notification");
            notification.put("body", "Happy Message!");
            
            JSONObject data = new JSONObject();
            data.put("Key-1", "JSA Data 1");
            data.put("Key-2", "JSA Data 2");

            body.put("notification", notification);
            body.put("data", data);

            HttpEntity<String> request = new HttpEntity<>(body.toString());

            CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
            CompletableFuture.allOf(pushNotification).join();

            try {
                String firebaseResponse = pushNotification.get();
                new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // 글쓰기
    @RequestMapping(value = "/deletearticle", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public int DeleteArticle(@RequestParam int article_no) {
        logger.info("Rest > DeleteArticle (POST, GET)");

        int result = svr_article.deleteArticle(article_no);

        return result;
    }

    // 글 수정
    @RequestMapping(value = "/updatearticle", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public int UpdateArticle(@RequestParam int article_no, @RequestParam String article_title,
            @RequestParam String article_content) {
        logger.info("Rest > UpdateArticle (POST, GET)");

        int result = svr_article.updateArticle(article_no, article_title, article_content);

        return result;
    }

    // 조회수 증가
    @RequestMapping(value = "/incresehit", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public int IncreseHit(@RequestParam int article_no) {
        logger.info("Rest > IncreseHit (POST, GET)");

        int result = svr_article.updateIncreseHit(article_no);

        return result;
    }

}
