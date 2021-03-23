package io.realworld.android.conduit.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.realworld.android.api.ConduitAuthClient;
import io.realworld.android.api.models.entities.User;
import io.realworld.android.api.models.responses.UserResponse;
import io.realworld.android.conduit.data.UserRepo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthViewModel extends ViewModel {

    private final MutableLiveData<User> _user = new MutableLiveData<>();

    public LiveData<User> user = _user;

    ConduitAuthClient conduitClient = new ConduitAuthClient();

    String token;

    void login(String email, String password){

        UserRepo userRepo = new UserRepo();
        Call<UserResponse> userResponseCall = userRepo.login(email,password);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                if (userResponse != null) {
                    _user.postValue(userResponse.getUser());
                    conduitClient.setAuthToken( "Token "+userResponse.getUser().getToken().trim());
                    Log.d("Login"," number of article "+userResponse.getUser().getToken());

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }

    void signup(String username, String email, String password){

        UserRepo userRepo = new UserRepo();
        Call<UserResponse> userResponseCall = userRepo.signup(username,email,password);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                if (userResponse != null) {
                    _user.postValue(userResponse.getUser());
                    conduitClient.setAuthToken("Token "+ userResponse.getUser().getToken().trim());
                    Log.d("Login"," number of article "+userResponse.getUser().getToken());

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }
     public void updateUser(String image, String bio, String email, String password, String username){

        UserRepo userRepo = new UserRepo();
        Call<UserResponse> userResponseCall = userRepo.updateUser(image,bio,email,password,username);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                if (userResponse != null) {
                    _user.postValue(userResponse.getUser());
                    Log.d("Login"," number of article "+userResponse.getUser().getToken());

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }
    public void logout(){
        _user.postValue(null);
    }

    public void getCurrentUser(String token) {
        UserRepo userRepo = new UserRepo();
        Call<UserResponse> userResponseCall = userRepo.getUser();
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                if (userResponse != null) {
                    _user.postValue(userResponse.getUser());
                    conduitClient.setAuthToken( "Token "+userResponse.getUser().getToken().trim());
                    Log.d("Login"," number of article "+userResponse.getUser().getToken());

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }
}