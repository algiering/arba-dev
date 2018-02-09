package com.web2.juha.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web2.juha.common.WebConstants;
import com.web2.juha.inf.IServiceArticle;
import com.web2.juha.inf.IServiceBoard;
import com.web2.juha.model.ModelArticle;
import com.web2.juha.model.ModelUser;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	IServiceArticle svr_article;
	
	@Autowired
	IServiceBoard svr_board;
	
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	public String Boardlist(Model model, HttpSession session) {
	    logger.info("Board > Boardlist(GET)");
	    
	    List<ModelArticle> game_article_list;
	    List<ModelArticle> hobby_article_list;
	    List<ModelArticle> electro_article_list;
	    List<ModelArticle> program_article_list;
	    List<ModelArticle> potable_article_list;
	    List<ModelArticle> qna_article_list;
	    
	    game_article_list = svr_article.getArticlePaging("", "game", 1, 10);
	    hobby_article_list = svr_article.getArticlePaging("", "hobby", 1, 10);
	    electro_article_list = svr_article.getArticlePaging("", "electro", 1, 10);
	    program_article_list = svr_article.getArticlePaging("", "program", 1, 10);
	    potable_article_list = svr_article.getArticlePaging("", "potable", 1, 10);
	    qna_article_list = svr_article.getArticlePaging("", "qna", 1, 10);
	    
	    ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        if (user != null) {
            model.addAttribute("login_check", true);
        } else {
            model.addAttribute("login_check", false);
        }
	    
	    model.addAttribute("game_article_list", game_article_list);
	    model.addAttribute("hobby_article_list", hobby_article_list);
	    model.addAttribute("electro_article_list", electro_article_list);
	    model.addAttribute("program_article_list", program_article_list);
	    model.addAttribute("potable_article_list", potable_article_list);
	    model.addAttribute("qna_article_list", qna_article_list);
	    
		return "boardlist";
	}
	
}
