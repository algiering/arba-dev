package com.web2.juha.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web2.juha.inf.IServiceArticle;
import com.web2.juha.model.ModelArticle;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	IServiceArticle svr_article;
	
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	public String Boardlist(Model model) {
	    logger.info("Board > Boardlist(GET)");
	    
	    List<ModelArticle> article_list;
	    
	    article_list = svr_article.getArticlePaging("", "mhw", 1, 10);
	    
	    model.addAttribute("article_list", article_list);
	    
		return "boardlist";
	}
	
}
