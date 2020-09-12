package com.hira_software.leaderboard;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.hira_software.leaderboard.model.FormResponse;
import com.hira_software.leaderboard.model.Hoarse;
import com.hira_software.leaderboard.model.PersonIQ;
import com.hira_software.leaderboard.retrofit.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {


    private  Retrofit retrofit;
    private  NetworkService networkService;
    private MutableLiveData<List<Hoarse>> topHourlyList;
    private MutableLiveData<List<PersonIQ>> topIQList;
    private MutableLiveData<String> registrationResponse;

public Repository(Application application,boolean form){
    String baseUrl="https://gadsapi.herokuapp.com/";
    if(form){
        baseUrl="https://docs.google.com/forms/u/0/d/e/";
    }
    retrofit=new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    networkService=retrofit.create(NetworkService.class);
    topIQList=new MutableLiveData<>();
    topHourlyList=new MutableLiveData<>();
    registrationResponse=new MutableLiveData<>();
}

    public MutableLiveData<List<Hoarse>> getTopHourlyList() {
        getHourly();
        return topHourlyList;
    }

    public MutableLiveData<String> getFormResponseMutableLiveData() {
        submitForm("Yohannes","mitike","jonmersha@gmail.com","Android on github");
        return registrationResponse;
    }
    public void getHourly(){
        networkService.getTopHousr().enqueue(new Callback<List<Hoarse>>() {
            @Override
            public void onResponse(Call<List<Hoarse>> call, Response<List<Hoarse>> response) {
                topHourlyList.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<Hoarse>> call, Throwable t) {
            }
        });
    }
    public void submitForm(String name, String lastName, String emailAdress, String projectLink) {
        networkService.googleForm(name,lastName,emailAdress,projectLink).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                registrationResponse.setValue("Success");
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                registrationResponse.setValue("Error");
            }
        });
    }
    public MutableLiveData<List<PersonIQ>> getTopIQList() {
        getTopIQLists();
        return  topIQList;
    }
    public void  getTopIQLists(){
        networkService.getTopIQ().enqueue(new Callback<List<PersonIQ>>() {
            @Override
            public void onResponse(Call<List<PersonIQ>> call, Response<List<PersonIQ>> response) {
                topIQList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PersonIQ>> call, Throwable t) {

            }
        });
    }
}
