package io.realworld.android.conduit.data;

import io.realworld.android.api.ConduitAuthClient;
import io.realworld.android.api.ConduitClient;
import io.realworld.android.api.Services.ConduitAPI;
import io.realworld.android.api.Services.ConduitAuthAPI;
import io.realworld.android.api.models.entities.LoginData;
import io.realworld.android.api.models.entities.SignupData;
import io.realworld.android.api.models.entities.UserUpdateData;
import io.realworld.android.api.models.requests.LoginRequest;
import io.realworld.android.api.models.requests.SignupRequest;
import io.realworld.android.api.models.requests.UserUpdateRequest;
import io.realworld.android.api.models.responses.UserResponse;
import retrofit2.Call;

public class UserRepo {

    ConduitAPI api =  new ConduitClient().api;
    ConduitAuthAPI authApi =  new ConduitAuthClient().authAPI;


    public Call<UserResponse> login(String email, String password){

        return api.loginUser(new LoginRequest(new LoginData(email,password)));
    }

    public Call<UserResponse> signup(String username, String email, String password) {
        return api.signupUser(new SignupRequest(new SignupData(username,email,password)));
    }
    public Call<UserResponse> updateUser(String image, String bio, String email, String password, String username) {
        return authApi.updateCurrentUser(new UserUpdateRequest(new UserUpdateData(image,bio,email,password,username)));
    }

    public Call<UserResponse> getUser() {
        return authApi.getCurrentUser();
    }
}
