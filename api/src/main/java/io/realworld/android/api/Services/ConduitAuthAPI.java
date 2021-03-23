package io.realworld.android.api.Services;

import io.realworld.android.api.models.requests.CreateArticleRequest;
import io.realworld.android.api.models.requests.UserUpdateRequest;
import io.realworld.android.api.models.responses.ArticleResponse;
import io.realworld.android.api.models.responses.ArticlesResponse;
import io.realworld.android.api.models.responses.ProfileResponse;
import io.realworld.android.api.models.responses.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ConduitAuthAPI {

    @GET("user")
    Call<UserResponse> getCurrentUser();

    @POST("articles")
    Call<ArticleResponse> postArticle(
            @Body CreateArticleRequest createArticleRequest
    );

    @PUT("user")
    Call<UserResponse> updateCurrentUser(
            @Body UserUpdateRequest userUpdateRequest
            );
    @GET("profiles/{username}")
    Call<ProfileResponse> getProfile(
            @Path("username") String username
    );
    @POST("profiles/{username}/follow")
    Call<ProfileResponse> followProfile(
            @Path("username") String username
    );
    @DELETE("profiles/{username}/follow")
    Call<ProfileResponse> unfollowProfile(
            @Path("username") String username
    );
    @GET("articles/feed")
    Call<ArticlesResponse> getFeedArticles();

    @GET("articles/{slug}/favorite")
    Call<ArticleResponse> favoriteArticle(
            @Path("slug") String slug
    );
    @DELETE("articles/{slug}/favorite")
    Call<ArticleResponse> unfavoriteArticle(
            @Path("slug") String slug
    );

}
