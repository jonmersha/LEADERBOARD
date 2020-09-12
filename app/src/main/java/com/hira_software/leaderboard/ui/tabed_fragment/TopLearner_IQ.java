package com.hira_software.leaderboard.ui.tabed_fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hira_software.leaderboard.R;
import com.hira_software.leaderboard.adaptor.TopHoarAdaptor;
import com.hira_software.leaderboard.adaptor.TopIQAdaptor;
import com.hira_software.leaderboard.model.Hoarse;
import com.hira_software.leaderboard.model.PersonIQ;
import com.hira_software.leaderboard.view_model.TopScoreViewModel;

import java.util.List;

public class TopLearner_IQ extends Fragment {

    private TopScoreViewModel topScoreViewModel;
    RecyclerView recyclerView;

    public static TopLearner_IQ newInstance() {
        return new TopLearner_IQ();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.top_learner__i_q_fragment, container, false);
        recyclerView=view.findViewById(R.id.listr);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        final TopIQAdaptor adapter=new TopIQAdaptor();

        recyclerView.setAdapter(adapter);

        TopScoreViewModel topScoreViewModel=new ViewModelProvider(this).get(TopScoreViewModel.class);

        topScoreViewModel.getPersonIQ().observe(getViewLifecycleOwner(), new Observer<List<PersonIQ>>() {
            @Override
            public void onChanged(List<PersonIQ> personIQS) {
               adapter.setPersonIQList(personIQS);
            }
        });
        return view;


    }





}