package io.realworld.android.conduit.data;

import io.realworld.android.api.ConduitClient;
import io.realworld.android.api.Services.ConduitAPI;
import io.realworld.android.api.models.entities.LoginData;
import io.realworld.android.api.models.entities.SignupData;
import io.realworld.android.api.models.requests.LoginRequest;
import io.realworld.android.api.models.requests.SignupRequest;
import io.realworld.android.api.models.responses.UserResponse;
import retrofit2.Call;

public class UserRepo {

    ConduitAPI api =  new ConduitClient().api;

    public Call<UserResponse> login(String email, String password){

        return api.loginUser(new LoginRequest(new LoginData(email,password)));
    }

    public Call<UserResponse> signup(String username, String email, String password) {
        return api.signupUser(new SignupRequest(new SignupData(username,email,password)));
    }
}
