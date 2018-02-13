package com.arba.appprj.https;

import com.arba.appprj.common.AppConstants;
import com.arba.appprj.inf.IArticle;
import com.arba.appprj.model.ModelArticle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

/**
 * Created by Administrator on 2018-02-12.
 */

public class HttpArticle implements IArticle {

    private static final String HTTP_URL_ARTICLELIST = AppConstants.HTTP_URL_BASE + "/getarticlelist";
    private static final String HTTP_URL_ARTICLEPAGING = AppConstants.HTTP_URL_BASE + "/getarticlepaging";
    private static final String HTTP_URL_ARTICLEONE = AppConstants.HTTP_URL_BASE + "/getarticleone";
    private static final String HTTP_URL_WRITEARTICLE = AppConstants.HTTP_URL_BASE + "/writearticle";
    private static final String HTTP_URL_DELETEARTICLE = AppConstants.HTTP_URL_BASE + "/deletearticle";
    private static final String HTTP_URL_UPDATEARTICLE = AppConstants.HTTP_URL_BASE + "/updatearticle";
    private static final String HTTP_URL_INCRESEHIT = AppConstants.HTTP_URL_BASE + "/incresehit";

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

    @Override
    public List<ModelArticle> getArticlePaging(String board_id, Integer start, Integer end) {

        List<ModelArticle> result = null;
        JSONArray response = null;

        try {
            request = new HttpRequest(HTTP_URL_ARTICLEPAGING);
            request.addBody("board_id", board_id);
            request.addBody("start", String.valueOf(start));
            request.addBody("end", String.valueOf(end));

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                response = request.getJSONArrayResponse();
            }

            result = new Gson().fromJson(response.toString(), new TypeToken<List<ModelArticle>>(){}.getType());

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
    public ModelArticle getArticleOne(String board_id, Integer article_no) {

        ModelArticle result = null;
        JSONObject response = null;

        try {
            request = new HttpRequest(HTTP_URL_ARTICLEONE);
            request.addBody("board_id", board_id);
            request.addBody("article_no", String.valueOf(article_no));

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                response = request.getJSONObjectResponse();
            }

            result = new Gson().fromJson(response.toString(), ModelArticle.class);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int insertArticle(String article_title, String article_content, String board_id) {
        int result = -2;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_WRITEARTICLE);
            request.addBody("board_id", board_id);
            request.addBody("article_title", article_title);
            request.addBody("article_content", article_content);

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                response = request.getStringResponse();
            }

            result = Integer.valueOf(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int deleteArticle(Integer article_no) {
        int result = -2;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_DELETEARTICLE);
            request.addBody("article_no", String.valueOf(article_no));

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                response = request.getStringResponse();
            }

            result = Integer.valueOf(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateArticle(Integer article_no, String article_title, String article_content) {
        int result = -2;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_UPDATEARTICLE);
            request.addBody("article_no", String.valueOf(article_no));
            request.addBody("article_title", article_title);
            request.addBody("article_content", article_content);

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                response = request.getStringResponse();
            }

            result = Integer.valueOf(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateIncreseHit(Integer article_no) {
        int result = -2;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_INCRESEHIT);
            request.addBody("article_no", String.valueOf(article_no));

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                response = request.getStringResponse();
            }

            result = Integer.valueOf(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
