package com.summary.network.interceptor;

import android.util.Log;

import com.summary.common.enctypt.Base64;
import com.summary.common.utils.toast.ToastUtils;
import com.zhouyou.http.interceptor.BaseExpiredInterceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *1 拦截cookie过期跳转登录页面
 * 2获取错误消息提示
 */
public class TokenInterceptor implements Interceptor {
    private String status_code = "";
    private String status_message = "";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        status_code = response.header("Status_code", "200");
        if (status_code=="401"){//重新登录

        }
        status_message = Base64.decodeToString(response.header("Status_msg", ""));
        Log.i("log_http", "isResponseExpired: status_message="+status_message+"status_code="+status_code);
        ToastUtils.show(status_message);
        return response;
    }
}
