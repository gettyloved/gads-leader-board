package com.dvilson.gadsleaderboard.services;

import java.net.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private static final String URL = "https://gadsapi.herokuapp.com/";
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit mRetrofit = builder.build();

    public static <S> S buildService(Class<S> serviceType){

        return mRetrofit.create(serviceType);
    }
}
