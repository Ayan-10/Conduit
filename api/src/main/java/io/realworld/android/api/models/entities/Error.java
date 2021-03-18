package io.realworld.android.api.models.entities;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Error {

	@SerializedName("body")
	private List<String> body;

	public void setBody(List<String> body){
		this.body = body;
	}

	public List<String> getBody(){
		return body;
	}
}