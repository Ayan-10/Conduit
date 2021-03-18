package io.realworld.android.api.models.entities;

import com.google.gson.annotations.SerializedName;

public class Profile{

	@SerializedName("image")
	private String image;

	@SerializedName("following")
	private boolean following;

	@SerializedName("bio")
	private String bio;

	@SerializedName("username")
	private String username;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setFollowing(boolean following){
		this.following = following;
	}

	public boolean isFollowing(){
		return following;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}