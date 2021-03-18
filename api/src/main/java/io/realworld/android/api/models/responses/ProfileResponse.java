package io.realworld.android.api.models.responses;

import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.Profile;

public class ProfileResponse{

	@SerializedName("profile")
	private Profile profile;

	public void setProfile(Profile profile){
		this.profile = profile;
	}

	public Profile getProfile(){
		return profile;
	}
}