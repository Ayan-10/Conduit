package io.realworld.android.api.models.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.Comment;

public class CommentsResponse{

	@SerializedName("comments")
	private List<Comment> comments;

	public void setComments(List<Comment> comments){
		this.comments = comments;
	}

	public List<Comment> getComments(){
		return comments;
	}
}