package com.spring81.bbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring81.bbs.common.WebConstants;
import com.spring81.bbs.inf.IServiceBoard;
import com.spring81.bbs.model.ModelBoard;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    IServiceBoard svrboard;

    /**
     * Simply selects the home view to render by returning its name.
     */

    // /board/boardlist?searchWord=
    @RequestMapping(value = "/board/boardlist", method = RequestMethod.GET)
    public String boardlist(Model model, @RequestParam(defaultValue = "") String searchWord) {
        logger.info("/board/boardlist");

        List<ModelBoard> result = svrboard.getBoardList(searchWord);

        // boardNm
        // list

        model.addAttribute("list", result);

        return "board/boardlist";
    }

    // /board/boardview
    // /board/boardview?=boardcd=qna
    @RequestMapping(value = "/board/boardview", method = RequestMethod.GET)
    public String boardview(Model model, @RequestParam(defaultValue = "free") String boardcd) {
        logger.info("/board/boardview");

        ModelBoard result = svrboard.getBoardOne(boardcd);

        model.addAttribute("board", result);

        return "board/boardview";
    }
    

    @RequestMapping(value = "/board/boardview/{boardcd}", method = RequestMethod.GET)
    public String boardview_path(Model model, @PathVariable(value="boardcd") String boardcd) {
        logger.info("/board/boardview");

        ModelBoard result = svrboard.getBoardOne(boardcd);

        model.addAttribute("board", result);

        return "board/boardview";
    }
    
    
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String boardview_path(Model model) {
        logger.info("/board/");

        return "board/";
    }
    
    @RequestMapping(value = "/board/boardmodify", method = RequestMethod.GET)
    public String boardmodify(Model model, @RequestParam(defaultValue="") String boardcd, HttpServletRequest request) {
        logger.info("/board/boardmodify");
        
        ModelBoard result = svrboard.getBoardOne(boardcd);
        
        String actionurl = request.getRequestURL().toString();
        
        model.addAttribute("boardnm", result.getBoardnm());
        model.addAttribute("board", result);
        model.addAttribute("actionurl", actionurl);

        return "board/boardmodify";
    }

    @RequestMapping(value = "/board/boardmodify/{boardcd}", method = RequestMethod.GET)
    public String boardmodify_path(Model model, @PathVariable(value="boardcd") String boardcd, HttpServletRequest request) {
        logger.info("/board/boardmodify");
        
        ModelBoard result = svrboard.getBoardOne(boardcd);
        
        String actionurl = request.getRequestURL().toString();
        
        model.addAttribute("boardnm", result.getBoardnm());
        model.addAttribute("board", result);
        model.addAttribute("actionurl", actionurl);

        return "board/boardmodify";
    }
    
    // 클라이언트 form태그에서 받을때
    @RequestMapping(value = "/board/boardmodify", method = RequestMethod.POST)
    public String boardmodift_post(Model model, @ModelAttribute ModelBoard setValue, RedirectAttributes rttr) {
        logger.info("/board/boardmodify");
        
        ModelBoard whereValue = new ModelBoard();
        whereValue.setBoardcd(setValue.getBoardcd());
        
        int result = svrboard.updateBoard(setValue, whereValue);
        
        if(result > 0) {
            return "redirect:/board/boardlist";
        }
        else {
            rttr.addFlashAttribute("msg", WebConstants.UPDATE_FAILED);
            rttr.addFlashAttribute("boardcd", setValue.getBoardcd());
            return "redirect:/board/boardmodify";
        }
        
    }

}
