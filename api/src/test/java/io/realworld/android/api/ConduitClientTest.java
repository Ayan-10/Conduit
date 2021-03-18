package io.realworld.android.api;

import org.junit.Test;

import java.io.IOException;

import io.realworld.android.api.models.entities.SignupData;
import io.realworld.android.api.models.entities.UserCreds;
import io.realworld.android.api.models.requests.SignupRequest;
import io.realworld.android.api.models.responses.ArticlesResponse;
import io.realworld.android.api.models.responses.UserResponse;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConduitClientTest {

    private final ConduitClient conduitClient = new ConduitClient();
    private final ConduitAuthClient conduitAuthClient = new ConduitAuthClient();
    @Test
    public void GET_Articles() throws IOException {
        Response<ArticlesResponse> articles = conduitClient.api.getArticles(null,null,null).execute();
        assertNotNull(articles.body());
    }
//    @Test
//    public void GET_Feed() throws IOException {
//        Response<ArticlesResponse> articles = conduitClient.conduitAuthAPI.getFeedArticles("Token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTUwNDg4LCJ1c2VybmFtZSI6ImF5YW5ya2FAZ21haWwuY29tIiwiZXhwIjoxNjIxMTg5NzIzfQ.enUZ9JRLZ7qmwHVAXdbGE1rlvc1veBl5bonSbaBQwlc").execute();
//        assertNotNull(articles.body());
//    }
    @Test
    public void GET_Articles_by_author() throws IOException {
        Response<ArticlesResponse> articles = conduitClient.api.getArticles("444",null,null).execute();
        assertNotNull(articles.body());
    }
    @Test
    public void GET_Articles_by_fav() throws IOException {
        Response<ArticlesResponse> articles = conduitClient.api.getArticles(null,null,null).execute();
        assertNotNull(articles.body());
    }
    @Test
    public void GET_Articles_by_tag() throws IOException {
        Response<ArticlesResponse> articles = conduitClient.api.getArticles("444",null,"dragons").execute();
        assertNotNull(articles.body());
    }
    @Test
    public void POST_user() throws IOException {
        SignupData userCreds = new SignupData("ayanrka@gmail.com","1234567oo9@cb.com","a99yanf2");
        SignupRequest signupRequest = new SignupRequest(userCreds);
        Response<UserResponse> users = conduitClient.api.signupUser(signupRequest).execute();
        assertEquals(signupRequest.getUser().getUsername(),users.body().getUser().getUsername());
    }
}
