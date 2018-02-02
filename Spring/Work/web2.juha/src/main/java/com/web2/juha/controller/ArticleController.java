package com.web2.juha.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web2.juha.common.PagingHelper;
import com.web2.juha.inf.IServiceArticle;
import com.web2.juha.model.ModelArticle;

@Controller
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    // @RequestMapping(value = "/", method = RequestMethod.GET)
    // public String home(Model model) {
    // logger.info("");
    //
    // return "home";
    // }

    @Autowired
    IServiceArticle svr_article;

    // 글목록 페이지
    @RequestMapping(value = "/articlelist/{board_id}/page={curPage}", method = RequestMethod.GET)
    public String Articlelist(Model model, @PathVariable(value = "board_id") String board_id,
            @PathVariable(value = "curPage") int curPage, @RequestParam(defaultValue = "") String searchWord,
            @RequestParam(defaultValue = "") String searchMode, RedirectAttributes rttr) {
        logger.info("Article > Articlelist(GET)");

        if (board_id == "-1") {
            return "";
        } else {
            int totalRecord = svr_article.getArticleTotalRecord(board_id, searchWord, searchMode);
            PagingHelper page = new PagingHelper(totalRecord, curPage);

            int start = page.getStartRecord();
            int end = page.getEndRecord();
            List<ModelArticle> article_list = svr_article.getArticlePaging(searchWord, board_id, start, end);

            model.addAttribute("article_list", article_list);
            model.addAttribute("board_id", board_id);
            model.addAttribute("searchWord", searchWord);
            model.addAttribute("searchMode", searchMode);

            model.addAttribute("curPage", curPage);
            model.addAttribute("totalFirstPage", page.getTotalFirstPage());
            model.addAttribute("prevLink", page.getPrevLink());
            model.addAttribute("pageLinks", page.getPageLinks());
            model.addAttribute("nextLink", page.getNextLink());
            model.addAttribute("totalLastPage", page.getTotalLastPage());

            return "articlelist";
        }
    }

    @RequestMapping(value = "/articlelist/{board_id}/article={article_subno}", method = RequestMethod.GET)
    public String Article(Model model, @PathVariable(value = "board_id") String board_id,
            @PathVariable(value = "article_subno") int article_subno) {
        logger.info("Article > Article(GET)");

        ModelArticle article = svr_article.getArticleOne(board_id, article_subno);

        model.addAttribute("article", article);
        model.addAttribute("board_id", board_id);

        return "article";
    }

}
