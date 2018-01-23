package com.exam8.juha;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.bbs.common.PagingHelper;

@Controller
public class PhoneController {

    private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);

    @Autowired
    IServicePhone svrphone;

    // @RequestMapping(value = "/phone/writemain", method = RequestMethod.GET)
    // public String writemain(Model model) {
    // logger.info("writemain");
    //
    // return "writemain";
    // }

    @RequestMapping(value = "/phone/writemain", method = RequestMethod.GET)
    public String writemain(Model model) {
        logger.info("writemain");

        return "phone/writemain";
    }

    @RequestMapping(value = "/phone/writeone1", method = RequestMethod.POST)
    public String writeone1(Model model, HttpServletRequest request) {
        logger.info("writeone1");

        String name = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        Integer price = Integer.valueOf(request.getParameter("price"));

        ModelPhone phone = new ModelPhone();
        phone.setName(name);
        phone.setManufacturer(manufacturer);
        phone.setPrice(price);

        int result = svrphone.insertPhone(phone);

        List<ModelPhone> list = svrphone.getPhoneList();

        model.addAttribute("list", list);

        return "redirect:/phone/writeoneresult";
    }

    @RequestMapping(value = "/phone/writeone2", method = RequestMethod.POST)
    public String writeone2(Model model, @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "manufacturer", defaultValue = "") String manufacturer,
            @RequestParam(value = "price", defaultValue = "0") Integer price, RedirectAttributes rttr) {
        logger.info("writeone2");

        ModelPhone phone = new ModelPhone();
        phone.setName(name);
        phone.setManufacturer(manufacturer);
        phone.setPrice(price);

        int result = svrphone.insertPhone(phone);
        if (result <= 0) {
            rttr.addFlashAttribute("msg", WebConstant.MSG_FAIL_INSERT);
            return "redirect:/phone/writemain";
        } 
        else {
            List<ModelPhone> list = svrphone.getPhoneList();

            model.addAttribute("list", list);

            return "redirect:/phone/writeoneresult";
        }
    }

    @RequestMapping(value = "/phone/writeone3", method = RequestMethod.POST)
    public String writeone3(Model model
            , @ModelAttribute ModelPhone phone
            , RedirectAttributes rttr) {
        logger.info("writeone3");

        int result = svrphone.insertPhone(phone);

        if (result <= 0) {
            rttr.addFlashAttribute("msg", WebConstant.MSG_FAIL_INSERT);
            return "redirect:/phone/writemain";
        } 
        else {
            List<ModelPhone> list = svrphone.getPhoneList();

            model.addAttribute("list", list);
            return "redirect:/phone/writeoneresult";
        }
    }

    @RequestMapping(value = "/phone/writeoneresult", method = RequestMethod.GET)
    public String writeoneresult(Model model
            , @RequestParam(defaultValue="1") Integer curPage) {
        logger.info("writeoneresult");
        
        // page
        
        // count all items
        int totalRecord = svrphone.getPhoneTotalRecord();
        
        // paging
        PagingHelper page = new PagingHelper(totalRecord, curPage, 5, 7);
        
        int start = page.getStartRecord();
        int end   = page.getEndRecord();

        List<ModelPhone> list = svrphone.getPhoneList(start, end);
        model.addAttribute("list", list);
        
        // no
        // prevLink
        // pageLinks
        // curPage
        // nextLink
        
        model.addAttribute("no", page.getListNo());
        model.addAttribute("prevLink", page.getPrevLink());
        model.addAttribute("pageLinks", page.getPageLinks());
        model.addAttribute("curPage", curPage);
        model.addAttribute("nextLink", page.getNextLink());
        
        return "phone/writeoneresult";
    }

}
