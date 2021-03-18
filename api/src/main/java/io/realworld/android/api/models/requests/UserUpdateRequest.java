package io.realworld.android.api.models.requests;

import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.UserCreds;
import io.realworld.android.api.models.entities.UserUpdateData;

public class UserUpdateRequest{

	@SerializedName("user")
	private UserUpdateData user;

	public void setUser(UserUpdateData user){
		this.user = user;
	}

	public UserUpdateData getUser(){
		return user;
	}
}