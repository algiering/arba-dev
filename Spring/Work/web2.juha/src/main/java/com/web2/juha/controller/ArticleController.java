package com.web2.juha.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web2.juha.common.PagingHelper;
import com.web2.juha.common.WebConstants;
import com.web2.juha.inf.IServiceArticle;
import com.web2.juha.inf.IServiceAttachFile;
import com.web2.juha.inf.IServiceBoard;
import com.web2.juha.inf.IServiceComment;
import com.web2.juha.inf.IServiceVote;
import com.web2.juha.model.ModelArticle;
import com.web2.juha.model.ModelAttachFile;
import com.web2.juha.model.ModelBoard;
import com.web2.juha.model.ModelComment;
import com.web2.juha.model.ModelUser;
import com.web2.juha.model.ModelVote;

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

    @Autowired
    IServiceComment svr_comment;

    @Autowired
    IServiceBoard svr_board;

    @Autowired
    IServiceVote svr_vote;

    @Autowired
    IServiceAttachFile svr_attachfile;

    // 글목록 페이지
    @RequestMapping(value = "/articlelist/{board_id}/page={curPage}", method = RequestMethod.GET)
    public String Articlelist(Model model, @PathVariable(value = "board_id") String board_id,
            @PathVariable(value = "curPage") int curPage, @RequestParam(defaultValue = "") String searchWord,
            @RequestParam(defaultValue = "") String searchMode, RedirectAttributes rttr, HttpSession session) {
        logger.info("Article > Articlelist(GET)");
        if (board_id == "") {
            return "";
        } else {
            int totalRecord = svr_article.getArticleTotalRecord(board_id, searchWord, searchMode);
            PagingHelper page = new PagingHelper(totalRecord, curPage);

            int start = page.getStartRecord();
            int end = page.getEndRecord();
            List<ModelArticle> article_list = svr_article.getArticlePaging(searchWord, board_id, start, end);

            ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
            if (user != null) {
                model.addAttribute("login_check", true);
            } else {
                model.addAttribute("login_check", false);
            }

            ModelBoard board = new ModelBoard();
            board.setBoard_id(board_id);
            board = svr_board.getBoardOne(board);

            model.addAttribute("board_title", board.getBoard_title());

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

    @RequestMapping(value = "/articlelist/{board_id}", method = RequestMethod.GET)
    public String home(Model model) {

        return "redirect:/articlelist/{board_id}/page=1";
    }

    @RequestMapping(value = "/articlelist/{board_id}/article={article_subno}", method = RequestMethod.GET)
    public String Article(Model model, @PathVariable(value = "board_id") String board_id,
            @PathVariable(value = "article_subno") int article_subno, HttpSession session) {
        logger.info("Article > Article(GET)");

        ModelArticle search_article = new ModelArticle();
        search_article.setBoard_id(board_id);
        search_article.setArticle_subno(article_subno);

        ModelArticle article = svr_article.getArticleOne(search_article);

        int increase_result = -2;
        increase_result = svr_article.updateIncreaseHit(article);

        ModelComment comment = new ModelComment();
        comment.setBoard_id(board_id);
        comment.setArticle_subno(article_subno);

        List<ModelComment> comment_list = svr_comment.getCommentList(comment);
        int comment_count = svr_comment.getCommentCount(comment);

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        if (user != null) {
            model.addAttribute("login_check", true);
            String user_id = user.getUser_id();
            model.addAttribute("user_id", user_id);
        } else {
            model.addAttribute("login_check", false);
        }

        ModelVote vote = new ModelVote();
        int article_no = article.getArticle_no();
        vote.setArticle_no(article_no);
        vote.setVote(1);

        int checkgood = -1;
        int checkbad = -1;

        int good_count = svr_vote.getVoteCount(vote);
        if (user != null) {
            vote.setUser_id(user.getUser_id());
            checkgood = svr_vote.getVoteCount(vote);
            vote.setUser_id(null);
        }
        vote.setVote(0);
        int bad_count = svr_vote.getVoteCount(vote);
        if (user != null) {
            vote.setUser_id(user.getUser_id());
            checkbad = svr_vote.getVoteCount(vote);
        }

        ModelBoard board = new ModelBoard();
        board.setBoard_id(board_id);
        board = svr_board.getBoardOne(board);

        model.addAttribute("board_title", board.getBoard_title());

        model.addAttribute("good_count", good_count);
        model.addAttribute("bad_count", bad_count);

        model.addAttribute("checkgood", checkgood);
        model.addAttribute("checkbad", checkbad);

        model.addAttribute("article", article);
        model.addAttribute("board_id", board_id);

        model.addAttribute("comment_list", comment_list);
        model.addAttribute("comment_count", comment_count);

        ModelAttachFile attachFile = new ModelAttachFile();
        attachFile.setBoard_id(board_id);
        attachFile.setArticle_subno(article_subno);
        attachFile = svr_attachfile.getAttachFileOne(attachFile);
        model.addAttribute("attachFile", attachFile);

        return "article";
    }

    @RequestMapping(value = "/articlelist/{board_id}/articlewrite", method = RequestMethod.GET)
    public String Articlewrite(Model model, @PathVariable(value = "board_id") String board_id, HttpSession session) {
        logger.info("Article > Articlewrite(GET)");

        ModelBoard board = new ModelBoard();
        board.setBoard_id(board_id);
        board = svr_board.getBoardOne(board);

        model.addAttribute("board_title", board.getBoard_title());

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        if (user == null) {
            model.addAttribute("login_check", false);
            return "redirect:/boardlist";
        } else {
            model.addAttribute("login_check", true);
            return "articlewrite";
        }
    }

    @RequestMapping(value = "/article_write", method = RequestMethod.POST)
    public String Article_write(Model model, @RequestParam(value = "upload") MultipartFile upload,
            @RequestParam String article_title, @RequestParam String article_content, @RequestParam String board_id,
            HttpSession session) {
        logger.info("Article > Article_write(POST)");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);

        if (user != null) {
            int result = -2;
            ModelArticle article = new ModelArticle();
            article.setArticle_title(article_title);
            article.setArticle_content(article_content);
            article.setBoard_id(board_id);
            article.setUser_id(user.getUser_id());
            result = svr_article.insertArticleOne(article);

            if (!upload.getOriginalFilename().isEmpty()) {
                int article_subno = result;
                // 서버의 업로드 폴더 존재 여부 체크. 없으면 폴더 생성
                java.io.File uploadDir = new java.io.File(WebConstants.UPLOAD_PATH);
                if (!uploadDir.exists())
                    uploadDir.mkdir();

                // 클라이언트의 파일을 서버로 복사
                String fileName = upload.getOriginalFilename();
                String tempName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                String newFile = WebConstants.UPLOAD_PATH + tempName; // c:/upload/20180123115415
                java.io.File serverfile = new java.io.File(newFile);

                try {
                    upload.transferTo(serverfile); // 실제로 파일 카피 발생.
                } catch (IllegalStateException e) {
                    logger.error("articlewrite" + e.getMessage());
                } catch (IOException e) {
                    logger.error("articlewrite" + e.getMessage());
                }

                // 파일을 서버로 복사 성공 여부 체크.
                // 성공한 경우만 tb_bbs_attachfile 테이블에 insert.
                if (serverfile.exists()) {
                    // 3. tb_bbs_attachfile 테이블에 insert.
                    ModelAttachFile attachFile = new ModelAttachFile();
                    attachFile.setArticle_subno(article_subno);
                    attachFile.setBoard_id(board_id);
                    attachFile.setFilenameorig(fileName);
                    attachFile.setFilenametemp(tempName);
                    attachFile.setFilesize(serverfile.length());
                    attachFile.setFiletype(upload.getContentType());

                    result = svr_attachfile.insertFileOne(attachFile);
                }
            }

            return "redirect:/articlelist/" + board_id;
        } else {
            return "";
        }

    }

    @RequestMapping(value = "/article_edit", method = RequestMethod.POST)
    public String Article_edit(Model model, @RequestParam(value = "upload") MultipartFile upload,
            @RequestParam String article_title, @RequestParam String article_content, @RequestParam String board_id, @RequestParam int article_subno,
            HttpSession session) {
        logger.info("Rest > Article_edit(POST)");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);

        if (user != null) {
            int result = -2;
            ModelArticle article = new ModelArticle();
            article.setArticle_title(article_title);
            article.setArticle_content(article_content);
            article.setArticle_subno(article_subno);
            article.setBoard_id(board_id);
            article.setUser_id(user.getUser_id());
            result = svr_article.updateArticleOne(article);

            if (!upload.getOriginalFilename().isEmpty()) {
                // 서버의 업로드 폴더 존재 여부 체크. 없으면 폴더 생성
                java.io.File uploadDir = new java.io.File(WebConstants.UPLOAD_PATH);
                if (!uploadDir.exists())
                    uploadDir.mkdir();

                // 클라이언트의 파일을 서버로 복사
                String fileName = upload.getOriginalFilename();
                String tempName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                String newFile = WebConstants.UPLOAD_PATH + tempName; // c:/upload/20180123115415
                java.io.File serverfile = new java.io.File(newFile);

                try {
                    upload.transferTo(serverfile); // 실제로 파일 카피 발생.
                } catch (IllegalStateException e) {
                    logger.error("articlewrite" + e.getMessage());
                } catch (IOException e) {
                    logger.error("articlewrite" + e.getMessage());
                }

                // 파일을 서버로 복사 성공 여부 체크.
                // 성공한 경우만 tb_bbs_attachfile 테이블에 insert.
                if (serverfile.exists()) {
                    // 3. tb_bbs_attachfile 테이블에 insert.
                    ModelAttachFile attachFile = new ModelAttachFile();
                    attachFile.setArticle_subno(article_subno);
                    attachFile.setBoard_id(board_id);
                    attachFile.setFilenameorig(fileName);
                    attachFile.setFilenametemp(tempName);
                    attachFile.setFilesize(serverfile.length());
                    attachFile.setFiletype(upload.getContentType());

                    result = svr_attachfile.insertFileOne(attachFile);
                }
            }
            return "redirect:/articlelist/" + board_id + "/article=" + article_subno;
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/articlelist/{board_id}/articleedit={article_subno}", method = RequestMethod.GET)
    public String Articleedit(Model model, @PathVariable(value = "board_id") String board_id, HttpSession session,
            @PathVariable(value = "article_subno") int article_subno) {
        logger.info("Article > Articlewrite(GET)");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        if (user == null) {
            return "redirect:/boardlist";
        } else {
            ModelArticle article = new ModelArticle();
            article.setArticle_subno(article_subno);
            article.setBoard_id(board_id);
            article = svr_article.getArticleOne(article);

            String article_title = article.getArticle_title();
            String article_content = article.getArticle_content();
            String user_id = article.getUser_id();

            model.addAttribute("article_title", article_title);
            model.addAttribute("article_content", article_content);
            model.addAttribute("user_id", user_id);

            ModelBoard board = new ModelBoard();
            board.setBoard_id(board_id);
            board = svr_board.getBoardOne(board);
            String board_title = board.getBoard_title();

            model.addAttribute("board_title", board_title);
            model.addAttribute("login_check", true);
            
            ModelAttachFile attachFile = new ModelAttachFile();
            attachFile.setBoard_id(board_id);
            attachFile.setArticle_subno(article_subno);
            attachFile = svr_attachfile.getAttachFileOne(attachFile);
            
            model.addAttribute("attachFile", attachFile);

            return "articleedit";
        }
    }

    @RequestMapping(value = "/articlelist/{board_id}/articledelete={article_subno}", method = RequestMethod.GET)
    public String Articledelete(Model model, @PathVariable(value = "board_id") String board_id,
            @PathVariable(value = "article_subno") int article_subno, HttpSession session) {
        logger.info("Article > Articledelete(GET)");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);

        if (user != null) {
            model.addAttribute("login_check", true);
            model.addAttribute("board_id", board_id);
            model.addAttribute("article_subno", article_subno);
            return "articledelete";
        } else {
            return "";
        }

    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public String download(Model model) {
        logger.info("/download");

        return "inc/download";
    }

}
