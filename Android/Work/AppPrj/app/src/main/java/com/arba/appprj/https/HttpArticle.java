package com.arba.appprj.https;

import com.arba.appprj.common.AppConstants;
import com.arba.appprj.inf.IArticle;
import com.arba.appprj.model.ModelArticle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

/**
 * Created by Administrator on 2018-02-12.
 */

public class HttpArticle implements IArticle {

    private static final String HTTP_URL_ARTICLELIST = AppConstants.HTTP_URL_BASE + "/getarticlelist";
    private HttpRequest request;
    private int httpCode = 0;
    
    @Override
    public List<ModelArticle> getArticleList() {
        
        List<ModelArticle> result = null;
        JSONArray response = null;

        try {
            request = new HttpRequest(HTTP_URL_ARTICLELIST);

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                response = request.getJSONArrayResponse();
            }
            result = new Gson().fromJson(response.toString(), new TypeToken<List<ModelArticle>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
