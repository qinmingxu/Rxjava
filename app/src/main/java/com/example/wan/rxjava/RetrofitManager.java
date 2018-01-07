package com.example.wan.rxjava;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hasee on 2017/12/29.
 */

public class RetrofitManager {
    public static final String BASE_URL = "https://www.zhaoapi.cn/";
    private final Retrofit mRetrofit;

    public static class SINGLE_HOLDER {
        public static final RetrofitManager INSTANCE = new RetrofitManager(BASE_URL);
    }

    public static RetrofitManager getInstance() {
        return SINGLE_HOLDER.INSTANCE;
    }


    private RetrofitManager(String baseUrl) {
        mRetrofit = buildRetrofit();
    }

    private OkHttpClient buildOkHttpClient() {
       return new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .build();
    }

    private Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .client(buildOkHttpClient())
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }
}
