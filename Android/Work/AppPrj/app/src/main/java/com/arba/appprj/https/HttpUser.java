package com.arba.appprj.https;


import com.arba.appprj.common.AppConstants;
import com.arba.appprj.inf.IUser;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Administrator on 2018-02-12.
 */

public class HttpUser implements IUser {

    private static final String HTTP_URL_LOGIN = AppConstants.HTTP_URL_BASE + "/login";

    private HttpRequest request = null;
    private int         httpCode = 0;

    @Override
    public int getLogin(String user_id, String user_pw) {
        int result = -3;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_LOGIN);
            request.configPostType(HttpRequest.MineType.VALUES);

            request.addBody("user_id", user_id);
            request.addBody("user_pw", user_pw);
            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                response = request.getStringResponse();
            }

            Gson gson = new Gson();
            result = Integer.valueOf(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
