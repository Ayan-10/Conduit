package io.realworld.android.api.models.entities;

import com.google.gson.annotations.SerializedName;

public class Comment{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("author")
	private Profile author;

	@SerializedName("id")
	private int id;

	@SerializedName("body")
	private String body;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setAuthor(Profile author){
		this.author = author;
	}

	public Profile getAuthor(){
		return author;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}
}