package com.example.dh_desafiofluxit.service;

import com.example.dh_desafiofluxit.model.UserResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {

    @GET("api/")
    Call<UserResult> getUsers(@Query("results") int limit,
                              @Query("gender") String genero,
                              @Query("page") int paginaActual,
                              @Query("seed") String seed);


}
