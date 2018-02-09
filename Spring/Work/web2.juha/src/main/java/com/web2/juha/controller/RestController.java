package com.web2.juha.controller;

import java.util.Date;

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
import com.web2.juha.inf.IServiceArticle;
import com.web2.juha.inf.IServiceAttachFile;
import com.web2.juha.inf.IServiceComment;
import com.web2.juha.inf.IServiceUser;
import com.web2.juha.inf.IServiceVote;
import com.web2.juha.model.ModelArticle;
import com.web2.juha.model.ModelAttachFile;
import com.web2.juha.model.ModelComment;
import com.web2.juha.model.ModelUser;
import com.web2.juha.model.ModelVote;

@Controller
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    IServiceUser svr_user;

    @Autowired
    IServiceArticle svr_article;

    @Autowired
    IServiceComment svr_comment;

    @Autowired
    IServiceVote svr_vote;

    @Autowired
    IServiceAttachFile svr_attachfile;

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
    public int Login(Model model, @RequestBody ModelUser user, HttpSession session) {
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

    // 로그아웃
    @RequestMapping(value = "/log_out", method = RequestMethod.GET)
    @ResponseBody
    public int Logout(Model model, HttpSession session) {
        logger.info("Rest > Log_out(get)");

        if (session.getAttribute(WebConstants.SESSION_NAME) != null) {
            session.removeAttribute(WebConstants.SESSION_NAME);
            return 1;
        } else {
            return 0;
        }
    }

    // 글쓰기
    // @RequestMapping(value = "/article_write", method = RequestMethod.POST)
    // @ResponseBody
    // public int Article_write(Model model, @RequestBody ModelArticle article,
    // HttpSession session) {
    // logger.info("Rest > Article_write(POST)");
    //
    // ModelUser user = (ModelUser)
    // session.getAttribute(WebConstants.SESSION_NAME);
    // article.setUser_id(user.getUser_id());
    //
    // int result = svr_article.insertArticleOne(article);
    //
    // return result;
    // }

    // 글삭제
    @RequestMapping(value = "/article_delete", method = RequestMethod.POST)
    @ResponseBody
    public int Article_delete(Model model, @RequestBody ModelArticle article, HttpSession session) {
        logger.info("Rest > Article_delete(POST)");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        article.setUser_id(user.getUser_id());

        int result = -2;
        if (user.getUser_id().equals(article.getUser_id())) {
            result = svr_article.updateDeleteArticle(article);
        }
        return result;
    }
    // 글수정
    // @RequestMapping(value = "/article_edit", method = RequestMethod.POST)
    // @ResponseBody
    // public int Article_edit(Model model, @RequestBody ModelArticle article,
    // HttpSession session) {
    // logger.info("Rest > Article_edit(POST)");
    // ModelUser user = (ModelUser)
    // session.getAttribute(WebConstants.SESSION_NAME);
    // String user_id = user.getUser_id();
    //
    // int result = -2;
    // if (article.getUser_id().equals(user_id)) {
    // result = svr_article.updateArticleOne(article);
    // }
    // return result;
    // }

    // 댓글 쓰기
    @RequestMapping(value = "/comment_write", method = RequestMethod.POST)
    public String Comment_write(Model model, @RequestBody ModelComment comment, HttpSession session) {
        logger.info("Rest > Comment_write");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        comment.setUser_id(user.getUser_id());

        int result = svr_comment.insertCommentOne(comment);

        if (result != -1) {
            Date comment_regdate = new Date();
            comment.setComment_regdate(comment_regdate);
            comment.setComment_no(result);
            model.addAttribute("commentadd", comment);

            return "commentadd";
        } else {
            return "";
        }
    }

    // 댓글 수정
    @RequestMapping(value = "/comment_edit", method = RequestMethod.POST)
    @ResponseBody
    public int Comment_edit(Model model, @RequestBody ModelComment comment, HttpSession session) {
        logger.info("Rest > Comment_edit");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        int result = -2;
        if (user != null) {
            comment.setUser_id(user.getUser_id());
            result = svr_comment.updateCommentOne(comment);
            return result;
        } else {
            return -3;
        }
    }

    // 댓글 삭제
    @RequestMapping(value = "/comment_delete", method = RequestMethod.POST)
    @ResponseBody
    public int Comment_delete(Model model, @RequestBody int comment_no, HttpSession session) {
        logger.info("Rest > Comment_delete(POST)");
        int result = -2;

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);

        if (user != null) {
            ModelComment comment = new ModelComment();
            comment.setComment_no(comment_no);
            result = svr_comment.updateDeleteComment(comment);
        }
        return result;
    }

    @RequestMapping(value = "/article_vote", method = RequestMethod.POST)
    @ResponseBody
    public int Article_vote(Model model, @RequestBody ModelVote vote, HttpSession session) {
        logger.info("Rest > Article_vote(POST)");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        if (user != null) {
            vote.setUser_id(user.getUser_id());
        }
        int result = -2;
        result = svr_vote.insertVote(vote);

        return result;
    }

    @RequestMapping(value = "/article_unvote", method = RequestMethod.POST)
    @ResponseBody
    public int Article_unvote(Model model, @RequestBody ModelVote vote, HttpSession session) {
        logger.info("Rest > Article_unvote(POST)");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        if (user != null) {
            vote.setUser_id(user.getUser_id());
        }
        int result = -2;
        result = svr_vote.deleteVote(vote);

        return result;
    }

    // 파일 삭제
    @RequestMapping(value = "/attachfile_delete", method = RequestMethod.POST)
    @ResponseBody
    public int Attachfile_delete(Model model, @RequestBody int attachfile_no, HttpSession session) {
        logger.info("Rest > Attachfile_delete(POST)");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        int result = -2;

        if (user != null) {
            ModelAttachFile attachFile = new ModelAttachFile();
            attachFile.setAttachfile_no(attachfile_no);
            result = svr_attachfile.deleteAttachFileOne(attachFile);
            return result;
        }

        else {
            return -3;
        }
    }
    
    // 회원 가입시 아이디 체크
    @RequestMapping(value = "/check_user_id", method = RequestMethod.POST)
    @ResponseBody
    public int Check_user_id(Model model, @RequestBody String user_id) {
        logger.info("Rest > Check_user_id(POST)");
        
        int result = -2;
        
        user_id = user_id.replaceAll("\"", "");
        
        result = svr_user.getCheckUserExist(user_id);
        
        return result;
    }

    // 회원 가입
    @RequestMapping(value = "/reg_user", method = RequestMethod.POST)
    @ResponseBody
    public int Reg_user(Model model, @RequestBody ModelUser user) {
        logger.info("Rest > Reg_user(POST)");
        int result = -2;
        
        result = svr_user.insertUserOne(user);
        
        return result;
    }
    
    // 회원 정보 수정
    @RequestMapping(value = "/edit_user", method = RequestMethod.POST)
    @ResponseBody
    public int Edit_user(Model model, @RequestBody ModelUser user, HttpSession session) {
        logger.info("Rest > Edit_user(POST)");
        int result = -2;
        
        result = svr_user.updateUserOne(user);
        
        if (result == 1) {
            user = svr_user.getUserOne(user);
            session.setAttribute(WebConstants.SESSION_NAME, user);
        }
        
        return result;
    }
}
