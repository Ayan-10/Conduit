package io.realworld.android.api.models.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

	@SerializedName("image")
	private String image;

	@SerializedName("bio")
	private String bio;

	@SerializedName("email")
	private String email;

	@SerializedName("token")
	private String token;

	@SerializedName("username")
	private String username;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}