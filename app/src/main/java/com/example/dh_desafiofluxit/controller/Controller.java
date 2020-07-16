package com.example.dh_desafiofluxit.controller;

import com.example.dh_desafiofluxit.model.UserResult;
import com.example.dh_desafiofluxit.model.dao.UserApiDao;
import com.example.dh_desafiofluxit.util.ResultListener;


public class Controller {

    private UserApiDao userApiDao;

    public Controller() {
        this.userApiDao = new UserApiDao();
    }

    public void getUsers(int limit, String genero, int offset, String seed, final ResultListener<UserResult> listener){
        userApiDao.getUsers(limit, genero, offset, seed, new ResultListener<UserResult>() {
            @Override
            public void onFinish(UserResult result) {
                listener.onFinish(result);
            }

            @Override
            public void onError() {
                listener.onError();
            }
        });
    }
}
