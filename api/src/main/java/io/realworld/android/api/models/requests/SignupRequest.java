package io.realworld.android.api.models.requests;

import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.SignupData;
import io.realworld.android.api.models.entities.UserCreds;

public class SignupRequest{

	@SerializedName("user")
	private SignupData user;

	public SignupRequest(SignupData userCreds) {
		this.user=userCreds;
	}

	public void setUser(SignupData user){
		this.user = user;
	}

	public SignupData getUser(){
		return user;
	}
}