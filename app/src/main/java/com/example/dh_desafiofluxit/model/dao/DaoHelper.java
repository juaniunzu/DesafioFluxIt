package com.example.dh_desafiofluxit.model.dao;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaoHelper {

    public Retrofit retrofit;
    public static final String BASE_URL = "https://randomuser.me/";

    public DaoHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
