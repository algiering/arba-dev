package com.spring61.rest.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

import com.spring61.rest.inf.IServiceBoard;
import com.spring61.rest.inf.IServiceUser;
import com.spring61.rest.model.ModelBoard;
import com.spring61.rest.model.ModelUser;

/**
 * Handles requests for the application home page.
 */
@Controller
// http://localhost:8080/rest/
@RequestMapping(value = "/rest")
public class RestContoller {

    private static final Logger logger = LoggerFactory.getLogger(RestContoller.class);

    // ServiceUser 인스턴스 만들기
    @Autowired
    IServiceUser usersvr;

    /**
     * Simply selects the home view to render by returning its name.
     */

    // @RequestMapping(value = "/", method = {RequestMethod.GET,
    // RequestMethod.POST})
    // @ResponseBody // json 형식으로 데이터 변환
    // public String home(Model model) {
    //
    // return "home";
    // }

    // http://localhost:8080/rest/selectuserlist
    @RequestMapping(value = "/curtime", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public long curtime(Model model) {
        logger.info("/rest/curtime");

        return new Date().getTime();
    }

    @RequestMapping(value = "/insertuser", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int insertuser( @RequestBody ModelUser user) {
        int result = -1;
        try {
            result = usersvr.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ModelUser login(String userid, String passwd) {
        ModelUser user = new ModelUser();
        try {
            user = usersvr.login(userid, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    @RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int logout(String userid) {
        int user = -1;
        try {
            user = usersvr.logout(userid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/updateuserinfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int updateuserinfo( @RequestBody ModelUser updateValue, @RequestBody ModelUser searchValue) {
        int result = -1;
        try {
            result = usersvr.updateUserInfo(updateValue, searchValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @RequestMapping(value = "/updatepasswd", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int updatepasswd(String userid, String currentPasswd, String newPasswd) {
        int user = -1;
        try {
            user = usersvr.updatePasswd(userid, currentPasswd, newPasswd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    @RequestMapping(value = "/deleteuser", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int deleteuser(ModelUser user) {
        int result = -1;
        try {
            result = usersvr.deleteUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @RequestMapping(value = "/selectuserone", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ModelUser selectuserone(ModelUser user) {
        ModelUser result = null;
        try {
            result = usersvr.selectUserOne(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @RequestMapping(value = "/selectuserlist", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody // json 형식으로 데이터 변환
    public List<ModelUser> selectuserlist(Model model) {
        List<ModelUser> list = new ArrayList<>();
        try {
            list = usersvr.selectUserList(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @RequestMapping(value = "/checkuserid", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int checkuserid(String userid) {
        int user = -1;
        try {
            user = usersvr.checkuserid(userid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    
    @Autowired
    IServiceBoard boardsvr;

    @RequestMapping(value = "/getboardname", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String getboardname( @RequestBody ModelBoard board) {
        String result = null;
        try {
            result = boardsvr.getBoardName(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @RequestMapping(value = "/getboardone", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ModelBoard getboardone( @RequestParam("cd") String boardcd) {
        logger.info("/rest/getboardone");
        ModelBoard board = new ModelBoard();
        try {
            board = boardsvr.getBoardOne(boardcd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;
    }
    
    @RequestMapping(value = "/getboardlist", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public List<ModelBoard> getboardlist() {
        logger.info("/rest/getboardone");
        List<ModelBoard> result = new ArrayList<>();
        try {
            result = boardsvr.getBoardList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    @RequestMapping(value = "/getboardtotalrecord", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public int getboardtotalrecord( @RequestBody ModelBoard board) {
        int result = -1;
        try {
            result = boardsvr.getBoardTotalRecord(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @RequestMapping(value = "/getboardpaging", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public List<ModelBoard> getboardpaging(String boardcd, String searchWord, @RequestParam(defaultValue="0") int start, @RequestParam(defaultValue="10") int end) {
        List<ModelBoard> result = null;
        try {
            result = boardsvr.getBoardPaging(boardcd, searchWord, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    
    
}
