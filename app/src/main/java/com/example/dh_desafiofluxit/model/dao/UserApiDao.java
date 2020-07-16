package com.example.dh_desafiofluxit.model.dao;

import androidx.annotation.Nullable;

import com.example.dh_desafiofluxit.model.UserResult;
import com.example.dh_desafiofluxit.service.UserService;
import com.example.dh_desafiofluxit.util.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserApiDao extends DaoHelper{

    private UserService userService;

    public UserApiDao() {
        super();
        userService = retrofit.create(UserService.class);
    }

    public void getUsers(int limit, String genero, int offset, String seed, final ResultListener<UserResult> listener){
        userService.getUsers(limit, genero, offset, seed).enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                listener.onFinish(response.body());
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                listener.onError();
                t.printStackTrace();
            }
        });
    }

}
