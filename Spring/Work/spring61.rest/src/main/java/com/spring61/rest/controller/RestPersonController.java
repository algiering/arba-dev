package com.spring61.rest.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

import com.google.gson.Gson;
import com.spring61.rest.model.ModelPerson;

@Controller
@RequestMapping(value = "/rest")
public class RestPersonController implements IPerson {

    private static final Logger logger = LoggerFactory.getLogger(RestPersonController.class);

    DataStorePerson service = new DataStorePerson();

    // http://localhost:8080/rest/curtime
    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#curtime(org.springframework.ui.Model)
     */
    @Override
    @RequestMapping(value = "/curtime", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public long curtime(Model model) {
        logger.info("/rest/curtime");

        return new Date().getTime();
    }

    // http://localhost:8080/rest/loginperson?id=userid&pw=password
    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#login(org.springframework.ui.Model, java.lang.String, java.lang.String)
     */
    @Override
    @RequestMapping(value = "/loginperson", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public long login(Model model, @RequestParam String id, @RequestParam String pw) {
        logger.info("/rest/loginperson");

        return service.login(id, pw);
    }

    // http://localhost:8080/rest/selectparam?name=id1
    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#selectparam(org.springframework.ui.Model, java.lang.String)
     */
    @Override
    @RequestMapping(value = "/selectparam", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public List<ModelPerson> selectparam(Model model, @RequestParam String name) {
        logger.info("/rest/selectparam");

        ModelPerson person = new ModelPerson();
        person.setName(name);

        return service.select(person);
    }

    // /rest/selectmodel :: form 태그를 이용하여 클라이언트의 데이터를 서버로 전송
    // <form action="/rest/selectmodel" method="post">
    // <input type="text" name="id" />
    // <input type="password" name="pw" />
    // <input type="text" name="name" />
    // <input type="text" name="email" />
    // <input type="button" value="send" />
    // </form>
    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#selectmodel(com.spring61.rest.model.ModelPerson)
     */
    @Override
    @RequestMapping(value = "/selectmodel", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public List<ModelPerson> selectmodel(@ModelAttribute ModelPerson person) {
        logger.info("/rest/selectmodel");

        return service.select(person);
    }

    // /rest/selectjson :: ajax 를 이용하여 json 데이터를 데이터를 클라이언트에서 서버로 전송.
    // var model = { 'id': '???', 'pw':'???', 'name':'???', 'email':'???' }
    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#selectjson(com.spring61.rest.model.ModelPerson)
     */
    @Override
    @RequestMapping(value = "/selectjson", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public List<ModelPerson> selectjson(@RequestBody ModelPerson person) {
        logger.info("/rest/selectjson");
        return service.select(person);
    }

    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#selectmap(org.springframework.ui.Model, java.util.Map)
     */
    @Override
    @RequestMapping(value = "/selectmap", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelPerson> selectmap(Model model
     , @RequestBody Map<String, Object> map) {
     logger.info("/rest/selectmap");

     // gson 을 이용하여 json 을 model 로 변환.
     ModelPerson person = new Gson().fromJson(map.get("searchvalue").toString(), ModelPerson.class);
     String name = (String) map.get("orderby");
     
     return service.makePersonData(100, 200);
    }
    
    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#selectpaging(org.springframework.ui.Model, int, int)
     */
    @Override
    @RequestMapping(value = "/selectpaging", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelPerson> selectpaging(Model model
     , @RequestParam int start
     , @RequestParam int end) {
     logger.info("/rest/selectpaging");

     List<ModelPerson> result = service.makePersonData(start, end);
     return result ;
    }
    
    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#insertparam(org.springframework.ui.Model, java.lang.String)
     */
    @Override
    @RequestMapping(value = "/insertparam", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public boolean insertparam(Model model
            , @RequestParam String name) {
     logger.info("/rest/insertparam");
     
     ModelPerson person = new ModelPerson();
     person.setName(name);
     
     return service.insert(person);
    }
    
    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#insertmodel(org.springframework.ui.Model, com.spring61.rest.model.ModelPerson)
     */
    @Override
    @RequestMapping(value = "/insertmodel", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public boolean insertmodel(Model model
            , @ModelAttribute ModelPerson person) {
     logger.info("/rest/insertmodel");
     
     return service.insert(person);
    }
    
    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#insertjsonobject(org.springframework.ui.Model, com.spring61.rest.model.ModelPerson)
     */
    @Override
    @RequestMapping(value = "/insertjsonobject", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public boolean insertjsonobject(Model model
            , @RequestBody ModelPerson person) {
     logger.info("/rest/insertjsonobject");
     
     return service.insert(person);
    }
    
    /* (non-Javadoc)
     * @see com.spring61.rest.controller.IPerson#insertjsonarray(org.springframework.ui.Model, java.util.List)
     */
    @Override
    @RequestMapping(value = "/insertjsonarray", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public boolean insertjsonarray(Model model
            , @RequestBody List<ModelPerson> person) {
     logger.info("/rest/insertjsonarray");
     
     return service.insert(person);
    }
}
