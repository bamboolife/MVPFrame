package com.summary.network.func;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * 转化实体
 * @param <T>
 */
public class CustomResultFunc<T> implements Function<ResponseBody,T> {
    protected Type type;
    protected Gson gson;

    public CustomResultFunc(Type type){
        gson=new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL,Modifier.TRANSIENT,Modifier.STATIC)
                .serializeNulls()
                .create();
        this.type=type;
    }


    @Override
    public T apply(ResponseBody responseBody) throws Exception {

        return null;
    }
}
