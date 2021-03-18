package io.realworld.android.api.models.responses;

import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.Article;

public class ArticleResponse{

	@SerializedName("article")
	private Article article;

	public void setArticle(Article article){
		this.article = article;
	}

	public Article getArticle(){
		return article;
	}
}