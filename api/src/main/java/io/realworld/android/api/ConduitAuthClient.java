package io.realworld.android.api;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import io.realworld.android.api.Services.BaseInterceptor;
import io.realworld.android.api.Services.ConduitAuthAPI;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ConduitAuthClient {

    static String authToken ;


    public void setAuthToken(String authToken) {
        ConduitAuthClient.authToken = authToken;
    }

    public static String getAuthToken() {
        return authToken;
    }

    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new BaseInterceptor(authToken))
            .build();

    Retrofit retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://conduit.productionready.io/api/") //https://api.github.com
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

    public ConduitAuthAPI authAPI = retrofitBuilder.create(ConduitAuthAPI.class);
}