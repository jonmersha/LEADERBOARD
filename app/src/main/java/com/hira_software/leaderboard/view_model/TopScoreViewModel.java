package com.hira_software.leaderboard.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hira_software.leaderboard.Repository;
import com.hira_software.leaderboard.model.Hoarse;
import com.hira_software.leaderboard.model.PersonIQ;

import java.util.List;

public class TopScoreViewModel extends AndroidViewModel {

   // Retrofit topScoreEnd;
    private MutableLiveData<List<Hoarse>> hours;
    private MutableLiveData<List<PersonIQ>> personIQ;

    private Repository repository;
    public TopScoreViewModel(@NonNull Application application) {
        super(application);

        repository=new Repository(application,false);
        hours =new MutableLiveData<>();
        personIQ=new MutableLiveData<>();
    }
    public LiveData<List<Hoarse>> getHours() {
        hours= repository.getTopHourlyList();
        return hours;
    }

    public MutableLiveData<List<PersonIQ>> getPersonIQ() {
        personIQ=repository.getTopIQList();
        return personIQ;
    }
}
