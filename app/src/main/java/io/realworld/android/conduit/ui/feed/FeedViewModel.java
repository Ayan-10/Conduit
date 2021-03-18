package io.realworld.android.conduit.ui.feed;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.realworld.android.api.ConduitAuthClient;
import io.realworld.android.api.models.entities.Article;
import io.realworld.android.api.models.responses.ArticlesResponse;
import io.realworld.android.conduit.data.ArticlesRepo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FeedViewModel extends ViewModel {

    private final MutableLiveData<List<Article>> _feed = new MutableLiveData<>();

    MutableLiveData<List<Article>> feed = _feed;

    void fetchGlobalFeed(){
        ArticlesRepo articlesRepo = new ArticlesRepo();
        Call<ArticlesResponse> arti = articlesRepo.getGlobalFeed();
        arti.enqueue(new Callback<ArticlesResponse>() {
            @Override
            public void onResponse(@NotNull Call<ArticlesResponse> call, @NotNull Response<ArticlesResponse> response) {
                ArticlesResponse articlesResponse = response.body();
                if (articlesResponse != null) {
                    _feed.postValue(articlesResponse.getArticless());
                    Log.d("Feed"," number of article"+articlesResponse.getArticlesCount());
                    Log.d("Feed"," number of article"+ ConduitAuthClient.getAuthToken());



                }
            }

            @Override
            public void onFailure(@NotNull Call<ArticlesResponse> call, @NotNull Throwable t) {

            }
        });
    }

    void fetchMyFeed(){
        ArticlesRepo articlesRepo = new ArticlesRepo();
        Call<ArticlesResponse> arti = articlesRepo.getMyFeed();
        arti.enqueue(new Callback<ArticlesResponse>() {
            @Override
            public void onResponse(Call<ArticlesResponse> call, Response<ArticlesResponse> response) {
                ArticlesResponse articlesResponse = response.body();
                if (articlesResponse != null) {
                    _feed.postValue(articlesResponse.getArticless());
                    Log.d("Auth Feed"," number of MY article"+articlesResponse.getArticlesCount());

                }
            }

            @Override
            public void onFailure(Call<ArticlesResponse> call, Throwable t) {

            }
        });


    }
}
