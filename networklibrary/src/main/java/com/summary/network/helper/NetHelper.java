package com.summary.network.helper;

import android.app.Application;

import com.zhouyou.http.BuildConfig;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.converter.SerializableDiskConverter;
import com.zhouyou.http.cookie.CookieManger;
import com.zhouyou.http.model.HttpHeaders;
import com.zhouyou.http.model.HttpParams;
import com.zhouyou.http.utils.HttpLog;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;


/**
 * 网络辅助工具类
 */
public class NetHelper {

    public void initNetWork(Application application,String urlPath) {
        EasyHttp.init(application);
        //全局设置请求头
        HttpHeaders headers=new HttpHeaders();
        headers.put("current_app","");
        headers.put("current_tenant","");
        headers.put("req_source","");
        headers.put("Accept-Language","");
        //设置全局请求参数
        HttpParams params=new HttpParams();
        //params.put("","");

        EasyHttp.getInstance()
                .debug("okhttp_log",true)
                .setReadTimeOut(10*1000)
                .setWriteTimeOut(10*1000)
                .setConnectTimeout(10*1000)
                .setRetryCount(3)//默认网络不好自动重试3次
                .setRetryDelay(500)//每次延时500ms重试
                .setRetryIncreaseDelay(500)//每次延时叠加500ms
                .setBaseUrl(urlPath)
                .setCookieStore(new CookieManger(application));
                //.setCacheDiskConverter(new SerializableDiskConverter())//默认缓存使用序列化转化
                //.setCacheMaxSize(50 * 1024 * 1024)//设置缓存大小为50M
                //.setCookieStore(new CookieManger(application))
                //.setCacheVersion(1);//缓存版本为1
                //.setHostnameVerifier(new UnSafeHostnameVerifier(urlPath))//全局访问规则
                //.setCertificates()//信任所有证书
                //.addConverterFactory(GsonConverterFactory.create(gson))//本框架没有采用Retrofit的Gson转化，所以不用配置
                //.addCommonHeaders(headers)//设置全局公共头
                //.addCommonParams(params)//设置全局公共参数
               // .addInterceptor(new CustomSignInterceptor());//添加参数签名拦截器
               //.addInterceptor(new HeTInterceptor());//处理自己业务的拦截器

    }

    public class UnSafeHostnameVerifier implements HostnameVerifier {
        private String host;

        public UnSafeHostnameVerifier(String host) {
            this.host = host;
            HttpLog.i("###############　UnSafeHostnameVerifier " + host);
        }

        @Override
        public boolean verify(String hostname, SSLSession session) {
            HttpLog.i("############### verify " + hostname + " " + this.host);
            if (this.host == null || "".equals(this.host) || !this.host.contains(hostname))
                return false;
            return true;
        }
    }
}
