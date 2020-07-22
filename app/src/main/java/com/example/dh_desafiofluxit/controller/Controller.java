package com.example.dh_desafiofluxit.controller;

import com.example.dh_desafiofluxit.model.UserResult;
import com.example.dh_desafiofluxit.model.dao.UserApiDao;
import com.example.dh_desafiofluxit.util.ResultListener;


public class Controller {

    private UserApiDao userApiDao;
    public static final String SEED = "asd";
    public static final int CANTIDAD_PAGINAS = 10;
    public static final int LIMIT = 20;
    private int paginaActual = 1;
    private Boolean hayMasResultados = true;

    public Controller() {
        this.userApiDao = new UserApiDao();
    }

    public void getUsers(String genero, final ResultListener<UserResult> listener){
        userApiDao.getUsers(LIMIT, genero, paginaActual, SEED, new ResultListener<UserResult>() {
            @Override
            public void onFinish(UserResult result) {
                listener.onFinish(result);
                paginaActual++;
                if(paginaActual == CANTIDAD_PAGINAS){
                    hayMasResultados = false;
                }
            }

            @Override
            public void onError() {
                listener.onError();
            }
        });
    }

    public Boolean getHayMasResultados() {
        return hayMasResultados;
    }
}
