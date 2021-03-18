package io.realworld.android.api.models.entities;

import com.google.gson.annotations.SerializedName;

public class UserUpdateData {
    @SerializedName("image")
    private String image;

    @SerializedName("bio")
    private String bio;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("username")
    private String username;

    public void setImage(String image){
        this.image = image;
    }

    public Object getImage(){
        return image;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    public String getBio(){
        return bio;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setToken(String token){
        this.password = token;
    }

    public String getToken(){
        return password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
}
