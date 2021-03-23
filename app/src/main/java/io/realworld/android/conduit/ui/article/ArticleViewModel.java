package io.realworld.android.conduit.ui.article;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.realworld.android.api.ConduitAuthClient;
import io.realworld.android.api.ConduitClient;
import io.realworld.android.api.Services.ConduitAPI;
import io.realworld.android.api.Services.ConduitAuthAPI;
import io.realworld.android.api.models.entities.Article;
import io.realworld.android.api.models.responses.ArticleResponse;
import io.realworld.android.api.models.responses.ArticlesResponse;
import io.realworld.android.api.models.responses.UserResponse;
import io.realworld.android.conduit.data.UserRepo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleViewModel extends ViewModel {

    ConduitAPI api =  new ConduitClient().api;
    ConduitAuthAPI authApi = new ConduitAuthClient().authAPI;

    private final MutableLiveData<Article> _article = new MutableLiveData<>();

    LiveData<Article> article = _article;

    void fetchArticle(String slug){

        Call<ArticleResponse> arti = api.getArticleBySlug(slug);
        arti.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                ArticleResponse articleResponse = response.body();
                if (articleResponse != null) {
                    _article.postValue(articleResponse.getArticle());
                }
                }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {

            }
        });

    }

    public void publishArticle(String titleText, String desText, String bodyText) {
        UserRepo userRepo = new UserRepo();
        Call<ArticleResponse> articleResponseCall = userRepo.postArticle(titleText,desText,bodyText);
        articleResponseCall.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                ArticleResponse articleResponse = response.body();
                if (articleResponse != null) {
                    _article.postValue(articleResponse.getArticle());
                    Log.d("Post Article"," Post art user "+articleResponse.getArticle().getAuthor());

                }
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {

            }
        });
    }
}
