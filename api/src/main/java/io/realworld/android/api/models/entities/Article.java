package io.realworld.android.api.models.entities;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Article{

	@SerializedName("tagList")
	private List<String> tagList;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("author")
	private Profile author;

	@SerializedName("description")
	private String description;

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	@SerializedName("favoritesCount")
	private int favoritesCount;

	@SerializedName("slug")
	private String slug;

	@SerializedName("updatedAt")
	private String updatedAt;

	@SerializedName("favorited")
	private boolean favorited;

	public void setTagList(List<String> tagList){
		this.tagList = tagList;
	}

	public List<String> getTagList(){
		return tagList;
	}

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

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setFavoritesCount(int favoritesCount){
		this.favoritesCount = favoritesCount;
	}

	public int getFavoritesCount(){
		return favoritesCount;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setFavorited(boolean favorited){
		this.favorited = favorited;
	}

	public boolean isFavorited(){
		return favorited;
	}
}