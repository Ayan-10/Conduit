package io.realworld.android.api.Services;

import org.jetbrains.annotations.Nullable;

import io.realworld.android.api.models.entities.UserCreds;
import io.realworld.android.api.models.requests.LoginRequest;
import io.realworld.android.api.models.requests.SignupRequest;
import io.realworld.android.api.models.responses.ArticleResponse;
import io.realworld.android.api.models.responses.ArticlesResponse;
import io.realworld.android.api.models.responses.TagsResponse;
import io.realworld.android.api.models.responses.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ConduitAPI {

    @GET("articles")
    Call<ArticlesResponse> getArticles(
            @Query("author") @Nullable String author,
            @Query("favourited") @Nullable String favourited,
            @Query("tag") @Nullable String tag
    );

    @POST("users")
    Call<UserResponse> signupUser(
            @Body SignupRequest userCreds
            );

    @POST("users/login")
    Call<UserResponse> loginUser(
            @Body LoginRequest userCreds
    );

    @GET("articles/{slug}")
    Call<ArticleResponse> getArticleBySlug(
            @Path("slug") String slug
    );

    @GET("tags")
    Call<TagsResponse> getTags();
}
