package io.realworld.android.api.models.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.Article;

public class ArticlesResponse{

	@SerializedName("articlesCount")
	private int articlesCount;

	@SerializedName("articles")
	private List<Article> articles;

	public void setArticlesCount(int articlesCount){
		this.articlesCount = articlesCount;
	}

	public int getArticlesCount(){
		return articlesCount;
	}

	public void setArticles(List<Article> articles){
		this.articles = articles;
	}

	public List<Article> getArticless(){
		return articles;
	}
}