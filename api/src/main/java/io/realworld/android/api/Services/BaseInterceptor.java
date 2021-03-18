package io.realworld.android.api.Services;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BaseInterceptor implements Interceptor {

    private String mCredentials;

    public BaseInterceptor(String token) {
        mCredentials =  token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request authRequest = request.newBuilder()
                .header("Authorization", mCredentials)
                .build();
        return chain.proceed(authRequest);
    }
}
