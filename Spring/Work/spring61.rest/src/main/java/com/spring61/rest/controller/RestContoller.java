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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring61.rest.inf.IServiceUser;
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
	
//	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody // json 형식으로 데이터 변환
//    public String home(Model model) {
//        
//        return "home";
//    }
	
	// http://localhost:8080/rest/selectuserlist
	@RequestMapping(value = "/selectuserlist", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody // json 형식으로 데이터 변환
	public List<ModelUser> home(Model model) {
		List<ModelUser> list = new ArrayList<>();
        try {
            list = usersvr.selectUserList(null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return list;
	}
	
}
