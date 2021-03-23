package io.realworld.android.api.models.requests;

import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.ArticleData;

public class CreateArticleRequest {

	@SerializedName("article")
	private ArticleData article;

	public CreateArticleRequest(ArticleData articleData) {
		this.article=articleData;
	}

	public void setArticle(ArticleData article){
		this.article = article;
	}

	public ArticleData getArticle(){
		return article;
	}
}