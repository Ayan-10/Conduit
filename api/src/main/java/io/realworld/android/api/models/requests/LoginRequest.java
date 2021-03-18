package io.realworld.android.api.models.requests;

import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.LoginData;
import io.realworld.android.api.models.entities.UserCreds;

public class LoginRequest{

	@SerializedName("user")
	private LoginData user;

	public LoginRequest(LoginData loginData) {
		this.user=loginData;
	}

	public void setUser(LoginData user){
		this.user = user;
	}

	public LoginData getUser(){
		return user;
	}
}