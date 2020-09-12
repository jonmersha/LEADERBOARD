package com.hira_software.leaderboard.view_model;

import android.app.Application;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hira_software.leaderboard.Repository;
import com.hira_software.leaderboard.model.FormResponse;
import com.hira_software.leaderboard.model.Hoarse;
import com.hira_software.leaderboard.model.PersonIQ;

import java.util.List;

public class GoogleFormViewModel extends AndroidViewModel {


    private MutableLiveData<String> formResponseMutableLiveData;



    private Repository repository;
    public GoogleFormViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application,true);


        formResponseMutableLiveData=new MutableLiveData<>();

    }

    public MutableLiveData<String> getFormResponse(String firstName, String lastName, String emialAddress, String projectName) {
        formResponseMutableLiveData=repository.getFormResponseMutableLiveData();
       return formResponseMutableLiveData;
    }
}
