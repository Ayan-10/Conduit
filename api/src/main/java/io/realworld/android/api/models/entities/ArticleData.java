package io.realworld.android.api.models.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleData {

    @SerializedName("body")
    private String body;

    @SerializedName("description")
    private String description;

    @SerializedName("tagList")
    private List<String> tagList;

    @SerializedName("title")
    private String title;

    public ArticleData(String titleText, String desText, String bodyText) {
        this.title = titleText;
        this.description = desText;
        this.body = bodyText;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
