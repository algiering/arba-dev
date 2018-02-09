package com.arba.testapp1;

import java.util.List;

/**
 * Created by Administrator on 2018-02-01.
 */

public interface IPerson {

    // http://localhost:8080/rest/curtime
    long curtime();

    // http://localhost:8080/rest/loginperson?id=userid&pw=password
    long loginperson(String id, String pw);

    // http://localhost:8080/rest/selectparam?name=id1
    List<ModelPerson> selectparam(String name);

    // /rest/selectmodel :: form 태그를 이용하여 클라이언트의 데이터를 서버로 전송
    // <form action="/rest/selectmodel" method="post">
    // <input type="text" name="id" />
    // <input type="password" name="pw" />
    // <input type="text" name="name" />
    // <input type="text" name="email" />
    // <input type="button" value="send" />
    // </form>
    List<ModelPerson> selectmodel(ModelPerson person);

    // /rest/selectjson :: ajax 를 이용하여 json 데이터를 데이터를 클라이언트에서 서버로 전송.
    // var model = { 'id': '???', 'pw':'???', 'name':'???', 'email':'???' }
    List<ModelPerson> selectjson(ModelPerson person);

    /**
     * 클라이언트 ---전송(JSONObject)---> 서버 --- 반환(JSONArray)--->클라이언트
     *
     * 1. 안드로이드 ---> 스프링 : 안드로이드는 json 을 스프링으로 전송한다.
     * 2. 스프링 ---> 안드로이드 : 스프링에서 안드로이드로 값을 1 개 반환한다.
     *
     * var map = {
     * 'searchvalue' : { 'id': '???', 'pw':'???', 'name':'???', 'email':'???' }
     * , 'orderby' : 'desc'
     * };
     */
    List<ModelPerson> selectmap(ModelPerson searchvalue, String orderby);

    List<ModelPerson> selectpaging(int start, int end);

    boolean insertparam(String name);

    boolean insertmodel(ModelPerson person);

    boolean insertjsonobject(ModelPerson person);

    boolean insertjsonarray(List<ModelPerson> person);

}
