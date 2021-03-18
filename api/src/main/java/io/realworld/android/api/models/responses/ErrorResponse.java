package io.realworld.android.api.models.responses;

import com.google.gson.annotations.SerializedName;

import io.realworld.android.api.models.entities.Error;

public class ErrorResponse{

	@SerializedName("errors")
	private Error errors;

	public void setErrors(Error errors){
		this.errors = errors;
	}

	public Error getErrors(){
		return errors;
	}
}