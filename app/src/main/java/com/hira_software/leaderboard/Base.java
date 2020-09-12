package com.hira_software.leaderboard;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Base extends Application {

    private Retrofit retrofit;
    @Override
    public void onCreate() {
        super.onCreate();
        retrofit=new Retrofit.Builder()
                .baseUrl("http://10.1.110.99:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
}
