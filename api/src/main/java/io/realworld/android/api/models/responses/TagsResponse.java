package io.realworld.android.api.models.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TagsResponse{

	@SerializedName("tags")
	private List<String> tags;

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}
}