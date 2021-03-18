package io.realworld.android.api.models.entities;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public LoginData(String email, String password) {
        this.email=email;
        this.password=password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
