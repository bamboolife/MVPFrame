package com.summary.sundy.helper;

import android.util.Log;

import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginHelper {

   public LoginHelper(){

   }

    public void login(String name, String pwd, SimpleCallBack<String> callBack){
        Map<String,String> params=new HashMap<>();
        params.put("username",name);
        params.put("password",pwd);
        params.put("captchaCode","");
        params.put("clientId","1234567");
        params.put("appName","com.summary.sundy");
        EasyHttp.post("/auth/login")
                .headers("current_app","A0003")
                .headers("Accept-Language","zh-CN")
                .upJson(new JSONObject(params).toString())
                .execute(callBack);
    }
}
