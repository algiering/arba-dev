package com.example.bbs.http;

import com.example.bbs.AppConstants;
import com.example.bbs.inf.IPerson;
import com.example.bbs.model.ModelPerson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-02-01.
 */

public class HttpPerson implements IPerson {

    private final static String HTTP_URL_CURTIME          = AppConstants.HTT_URL_BASE + "/rest/curtime";
    private final static String HTTP_URL_LOGINPERSON      = AppConstants.HTT_URL_BASE + "/rest/loginperson";
    private final static String HTTP_URL_SELECTPARAM      = AppConstants.HTT_URL_BASE + "/rest/selectparam";
    private final static String HTTP_URL_SELECTMODEL      = AppConstants.HTT_URL_BASE + "/rest/selectmodel";
    private final static String HTTP_URL_SELECTJSON       = AppConstants.HTT_URL_BASE + "/rest/selectjson";
    private final static String HTTP_URL_SELECTMAP        = AppConstants.HTT_URL_BASE + "/rest/selectmap";
    private final static String HTTP_URL_SELECTPAGING     = AppConstants.HTT_URL_BASE + "/rest/selectpaging";
    private final static String HTTP_URL_INSERTPARAM      = AppConstants.HTT_URL_BASE + "/rest/insertparam";
    private final static String HTTP_URL_INSERTMODEL      = AppConstants.HTT_URL_BASE + "/rest/insertmodel";
    private final static String HTTP_URL_INSERTJSONOBJECT = AppConstants.HTT_URL_BASE + "/rest/insertjsonobject";
    private final static String HTTP_URL_INSERTJSONARRAY  = AppConstants.HTT_URL_BASE + "/rest/insertjsonarray";

    private HttpRequest request  = null;
    private int         httpCode = 0;

    @Override
    public long curtime() {
        long result = -1;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_CURTIME);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.configPostType(HttpRequest.MineType.VALUES);

        try {
            httpCode = request.get();
            // httpCode = request.post();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if ( httpCode == HttpURLConnection.HTTP_OK ) { // 200 = 정상
            try {
                response = request.getStringResponse();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        result = Long.valueOf(response);

        return result;
    }

    @Override
    public long loginperson(String id, String pw) {
        long result = -1;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_LOGINPERSON);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addParameter("id", id);
            request.addParameter("pw", pw);

            httpCode = request.post();

            if( httpCode == HttpURLConnection.HTTP_OK) {
                response = request.getStringResponse();
            }

            result = Long.valueOf(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<ModelPerson> selectparam(String name) {
        List<ModelPerson> result = null;
        JSONArray response = null;

        try {
            request = new HttpRequest(HTTP_URL_SELECTPARAM);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addParameter("name", name);

            httpCode = request.post();

            if ( httpCode == HttpURLConnection.HTTP_OK ) {
                response = request.getJSONArrayResponse();
            }

            result = new Gson().fromJson(response.toString(), new TypeToken<List<ModelPerson>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<ModelPerson> selectmodel(ModelPerson person) {

        List<ModelPerson> result = null;
        JSONArray response = null;

        try {
            request = new HttpRequest(HTTP_URL_SELECTMODEL);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addParameter("id"   , person.getId()   );
            request.addParameter("pw"   , person.getPw()   );
            request.addParameter("name" , person.getName() );
            request.addParameter("email", person.getEmail());

            httpCode = request.post();

            if ( httpCode == HttpURLConnection.HTTP_OK) {
                response = request.getJSONArrayResponse();
            }

            result = new Gson().fromJson(response.toString(), new TypeToken<List<ModelPerson>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<ModelPerson> selectjson(ModelPerson person) {

        List<ModelPerson> result = null;
        JSONArray response = null;
        Gson gson = new Gson();

        try {
            request = new HttpRequest(HTTP_URL_SELECTJSON);
            request.configPostType(HttpRequest.MineType.JSONObject);
            String jsonString = gson.toJson(person);
            httpCode = request.post(jsonString);

            if ( httpCode == HttpURLConnection.HTTP_OK) {
                response = request.getJSONArrayResponse();
            }

            result = gson.fromJson(response.toString(), new TypeToken<List<ModelPerson>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<ModelPerson> selectmap(ModelPerson searchvalue, String orderby) {

        List<ModelPerson> result = null;
        JSONArray response = null;
        Gson gson = new Gson();

        try {
            request = new HttpRequest(HTTP_URL_SELECTMAP);
            request.configPostType(HttpRequest.MineType.JSONArray);

            Map<String, Object> map = new HashMap<>();
            map.put("searchvalue", searchvalue);
            map.put("orderby", orderby);
            String jsonString = gson.toJson(map);
            httpCode = request.post(jsonString);

            if ( httpCode == HttpURLConnection.HTTP_OK) {
                response = request.getJSONArrayResponse();
            }

            result = gson.fromJson(response.toString(), new TypeToken<List<ModelPerson>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ModelPerson> selectpaging(int start, int end) {

        List<ModelPerson> result = null;
        JSONArray response = null;

        try {
            request = new HttpRequest(HTTP_URL_SELECTPAGING);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addParameter("start", start + "");
            request.addParameter("end", end + "");

            request.post();

            httpCode = request.post();

            if ( httpCode == HttpURLConnection.HTTP_OK ) {
                response = request.getJSONArrayResponse();
            }

            result = new Gson().fromJson(response.toString(), new TypeToken<List<ModelPerson>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean insertparam(String name) {
        boolean result = false;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_INSERTPARAM);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addParameter("name", name);

            httpCode = request.post();

            if ( httpCode == HttpURLConnection.HTTP_OK) {
                response = request.getStringResponse();
            }

            result = Boolean.valueOf(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean insertmodel(ModelPerson person) {
        boolean result = false;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_INSERTMODEL);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addParameter("id", person.getId());
            request.addParameter("pw", person.getPw());
            request.addParameter("name", person.getName());
            request.addParameter("email", person.getEmail());

            httpCode = request.post();

            if ( httpCode == HttpURLConnection.HTTP_OK ) {
                response = request.getStringResponse();
            }

            result = Boolean.valueOf(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean insertjsonobject(ModelPerson person) {
        boolean result = false;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_INSERTJSONOBJECT);
            request.configPostType(HttpRequest.MineType.JSONObject);

            httpCode = request.post(new Gson().toJson(person));

            if ( httpCode == HttpURLConnection.HTTP_OK ) {
                response = request.getStringResponse();
            }

            result = Boolean.valueOf(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean insertjsonarray(List<ModelPerson> person) {
        boolean result = false;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_INSERTJSONARRAY);
            request.configPostType(HttpRequest.MineType.JSONArray);

            httpCode = request.post(new Gson().toJson(person));

            if ( httpCode == HttpURLConnection.HTTP_OK ) {
                response = request.getStringResponse();
            }

            result = Boolean.valueOf(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
