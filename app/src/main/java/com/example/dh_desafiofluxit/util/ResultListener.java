package com.example.dh_desafiofluxit.util;

public interface ResultListener<T> {

    void onFinish(T result);
    void onError();
}
