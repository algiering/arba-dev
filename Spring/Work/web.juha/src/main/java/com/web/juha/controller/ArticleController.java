package com.web.juha.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.web.juha.common.PagingHelper;
import com.web.juha.inf.IServiceArticle;
import com.web.juha.inf.IServiceComment;
import com.web.juha.inf.IServiceRecomment;
import com.web.juha.model.ModelArticle;
import com.web.juha.model.ModelComment;
import com.web.juha.model.ModelRecomment;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    IServiceArticle svr_article;

    @Autowired
    IServiceComment svr_comment;

    @Autowired
    IServiceRecomment svr_recomment;

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String article(Model model
            , @RequestParam(defaultValue = "-1") Integer article_subno
            , @RequestParam(defaultValue = "-1") Integer board_id) {
        logger.info("");

        svr_article.increaseHit(article_subno, board_id);

        ModelArticle article = new ModelArticle();
        article = svr_article.getArticleOne(article_subno, board_id);

        String article_title = article.getArticle_title();
        String article_content = article.getArticle_content();
        String user_id = article.getUser_id();
        int hit = article.getHit();
        Date article_regdate = article.getArticle_regdate();
        int good = article.getGood();
        int bad = article.getBad();

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-DD");
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

        Integer article_no = article.getArticle_no();
        user_id = "algiering"; // TODO 세션에서 가져오도록 변경

        List<ModelComment> comment = svr_comment.getCommentList(article_no);

        List<Integer> comment_no_list = new ArrayList<>();

        for (ModelComment modelComment : comment) {
            comment_no_list.add(modelComment.getComment_no());
        }

        List<ModelRecomment> recomment = new ArrayList<>();
        for (Integer comment_no : comment_no_list) {
            recomment.addAll(svr_recomment.getRecommentList(comment_no));
        }

        model.addAttribute("article_subno", article_subno);
        model.addAttribute("article_title", article_title);
        model.addAttribute("article_content", article_content);
        model.addAttribute("user_id", user_id);
        model.addAttribute("hit", hit);
        model.addAttribute("article_regdate", format1.format(article_regdate));
        model.addAttribute("article_regtime", format2.format(article_regdate));

        model.addAttribute("good", good);
        model.addAttribute("bad", bad);

        model.addAttribute("comment_list", comment);

        model.addAttribute("recomment_list", recomment);
        
        model.addAttribute("board_id", board_id);

        return "article";
    }

    @RequestMapping(value = "/articlelist", method = RequestMethod.GET)
    public String articlelist(Model model
            , @RequestParam(defaultValue = "-1") int board_id
            , @RequestParam(defaultValue = "") String searchWord
            , @RequestParam(defaultValue = "1") int curPage) {
        logger.info("");
        
        int totalRecord = svr_article.getCountArticleList(board_id, searchWord);
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage, 10, 10);

        int start = paging.getStartRecord();
        int end = paging.getEndRecord();
        
        List<ModelArticle> result = svr_article.getArticlePaging(board_id, searchWord, start, end);

        model.addAttribute("article_list", result);
        
        model.addAttribute("curPage", curPage);
        model.addAttribute("searchWord", searchWord);
        
        model.addAttribute("prevLink", paging.getPrevLink());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("nextLink", paging.getNextLink());
        
        model.addAttribute("totalLastPage", paging.getTotalLastPage());
        model.addAttribute("totalFirstPage", paging.getTotalFirstPage());

        return "articlelist";
    }

    @RequestMapping(value = "/article_vote", method = RequestMethod.POST)
    @ResponseBody
    public int article_vote(Model model
            , @RequestParam("article_subno") int article_no
            , @RequestParam("clicked") int clicked
            , @RequestParam("board_id") int board_id) {
        logger.info("");
        
        ModelArticle result;

        if (clicked == 0) {
            svr_article.increaseGood(article_no, board_id);
            result = svr_article.getArticleOne(article_no, board_id);
            return result.getGood();
        } 
        
        else if (clicked == 1) {
            svr_article.increaseBad(article_no, board_id);
            result = svr_article.getArticleOne(article_no, board_id);
            return result.getBad();
        } 
        
        else {
            return -1;
        }
    }
    
    @RequestMapping(value = "/articlewrite", method = RequestMethod.GET)
    public String articlewrite(Model model
            , @RequestParam(defaultValue="-1") int board_id) {
        logger.info("");
        
        model.addAttribute("board_id", board_id);
        
        return "articlewrite";
    }
    
    @RequestMapping(value = "/article_write", method = RequestMethod.POST)
    @ResponseBody
    public int article_write(Model model
            , @RequestParam String article_title
            , @RequestParam String article_content
            , @RequestParam String user_id
            , @RequestParam Integer board_id) {
        logger.info("");
        int result = -1;
        
        result = svr_article.insertArticle(article_title, article_content, user_id, board_id);
        
        return result;
    }
    
    @RequestMapping(value = "/articledelete", method = RequestMethod.GET)
    public String articledelete(Model model
            , @RequestParam int article_subno
            , @RequestParam int board_id
            , @RequestParam String user_id) {
        logger.info("");
        
        model.addAttribute("article_subno", article_subno);
        model.addAttribute("board_id", board_id);
        model.addAttribute("user_id", user_id);
        
        return "articledelete";
    }
    
    @RequestMapping(value = "/article_delete", method = RequestMethod.POST)
    @ResponseBody
    public int article_delete(Model model
            , @RequestParam int article_subno
            , @RequestParam int board_id
            , @RequestParam String user_id) {
        int result = -1;
        
        result = svr_article.deleteArticle(board_id, article_subno);
        
        return result;
    }
    
    @RequestMapping(value = "/articleedit", method = RequestMethod.GET)
    public String articleedit(Model model
            , @RequestParam int article_subno
            , @RequestParam int board_id
            , @RequestParam String user_id) {
        logger.info("");
        
        model.addAttribute("article_subno", article_subno);
        model.addAttribute("board_id", board_id);
        model.addAttribute("user_id", user_id);
        
        return "articleedit";
    }
    
    @RequestMapping(value = "/article_getone", method = RequestMethod.POST)
    @ResponseBody
    public ModelArticle article_getone(Model model
            , @RequestBody ModelArticle mdata) {
        logger.info("");
        
        int article_subno = mdata.getArticle_subno();
        int board_id = mdata.getBoard_id();
        
        ModelArticle article = svr_article.getArticleOne(article_subno, board_id);
        
        return article;
    }
    
    @RequestMapping(value = "/article_edit", method = RequestMethod.POST)
    @ResponseBody
    public int article_edit(Model model
            , @RequestBody ModelArticle mdata) {
        logger.info("");
        
        int article_subno = mdata.getArticle_subno();
        int board_id = mdata.getBoard_id();
        String article_title = mdata.getArticle_title();
        String article_content = mdata.getArticle_content();
        
        int result = svr_article.updateArticle(board_id, article_subno, article_title, article_content);
        
        return result;
    }
    
    @RequestMapping(value = "/comment_insert", method = RequestMethod.POST)
    public String article_edit(Model model
            , @RequestBody Map<String, Object> map) {
        logger.info("");
        
        ModelArticle article = new Gson().fromJson(map.get("mdata2").toString(), ModelArticle.class);
        ModelComment mComment = new Gson().fromJson(map.get("mdata").toString(), ModelComment.class);
        
        int article_subno = article.getArticle_subno();
        int board_id = article.getBoard_id();
        
        String comment_content = mComment.getComment_content();
        String user_id = mComment.getUser_id();
        
        article = svr_article.getArticleOne(article_subno, board_id);
        
        int article_no = article.getArticle_no();
         
        int result = -2;
        
        result = svr_comment.insertComment(comment_content, article_no, user_id);
        
        int comment_no = svr_comment.getCommentLastNo();
        
        ModelComment comment = svr_comment.getCommentOne(comment_no);
        
        model.addAttribute("comment", comment);
        
        return "article_comment_list";
    }
}
