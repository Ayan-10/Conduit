package io.realworld.android.api.models.responses;

import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.Comment;

public class CommentResponse{

	@SerializedName("comment")
	private Comment comment;

	public void setComment(Comment comment){
		this.comment = comment;
	}

	public Comment getComment(){
		return comment;
	}
}