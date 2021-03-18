package io.realworld.android.api.models.entities;

import com.google.gson.annotations.SerializedName;

public class UserCreds {

	@SerializedName("password")
	private String password;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public UserCreds(String s, String s1, String ayanf2) {
		this.email=s;
		this.password=s1;
		this.username=ayanf2;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}