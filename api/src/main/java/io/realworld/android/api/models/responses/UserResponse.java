package io.realworld.android.api.models.responses;

import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.User;

public class UserResponse{

	@SerializedName("user")
	private User user;

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}