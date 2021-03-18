package io.realworld.android.api;

import io.realworld.android.api.Services.ConduitAPI;
import io.realworld.android.api.Services.ConduitAuthAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConduitClient {

    Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://conduit.productionready.io/api/") //https://api.github.com
            .addConverterFactory(GsonConverterFactory.create());

    public ConduitAPI api = retrofitBuilder.build().create(ConduitAPI.class);


}