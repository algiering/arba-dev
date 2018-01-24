package com.web.juha.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		
		ModelArticle article = new ModelArticle();
		article = svr_article.getArticleOne(article_subno, board_id);
		
		article_subno          = article.getArticle_subno();
		String article_title   = article.getArticle_title();
		String article_content = article.getArticle_content();
		String user_id         = article.getUser_id();
		int hit                = article.getHit();
		Date article_regdate   = article.getArticle_regdate();
		int good               = article.getGood();
		int bad                = article.getBad();
		
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
		
		model.addAttribute("article_subno",   article_subno                   );
		model.addAttribute("article_title",   article_title                   );
		model.addAttribute("article_content", article_content                 );
		model.addAttribute("user_id",         user_id                         );
		model.addAttribute("hit",             hit                             );
		model.addAttribute("article_regdate", format1.format(article_regdate) );
		model.addAttribute("article_regtime", format2.format(article_regdate) );
		
		model.addAttribute("good",            good                            );
		model.addAttribute("bad",             bad                             );
		
		model.addAttribute("comment_list",    comment                         );
		
		model.addAttribute("recomment_list",  recomment                       );
		
		svr_article.increaseHit(article_no);
		
		return "article";
	}
	
	@RequestMapping(value = "/articlelist", method = RequestMethod.GET)
    public String articlelist(Model model
            , @RequestParam(defaultValue = "-1") int board_id) {
        logger.info("");
        
        List<ModelArticle> result = svr_article.getArticleList(board_id);
        
        model.addAttribute("article_list", result);
        
        return "articlelist";
    }
	
	@RequestMapping(value = "/article_vote", method = RequestMethod.GET)
	@ResponseBody
    public int article_vote(Model model
            , @RequestParam("article_no") int article_no
            , @RequestParam("clicked") int clicked) {
        if(clicked == 0) {
            
        }
        else if(clicked == 1) {
            
        }
	    
        return 0;
    }
	
}
