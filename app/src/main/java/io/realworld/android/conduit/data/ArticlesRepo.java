package io.realworld.android.conduit.data;


import io.realworld.android.api.ConduitAuthClient;
import io.realworld.android.api.ConduitClient;
import io.realworld.android.api.Services.ConduitAPI;
import io.realworld.android.api.Services.ConduitAuthAPI;
import io.realworld.android.api.models.responses.ArticlesResponse;
import retrofit2.Call;

public class ArticlesRepo {

    ConduitAPI api =  new ConduitClient().api;
    ConduitAuthAPI authAPI = new ConduitAuthClient().authAPI;

    public Call<ArticlesResponse> getGlobalFeed(){

        return api.getArticles(null,null,null);
    }

    public Call<ArticlesResponse> getMyFeed(){
        return authAPI.getFeedArticles();
    }
}
