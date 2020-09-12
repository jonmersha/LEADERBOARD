package com.hira_software.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hira_software.leaderboard.model.FormResponse;
import com.hira_software.leaderboard.view_model.GoogleFormViewModel;

import java.util.List;

public class ProjectSubmission extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText emialAddress;
    private EditText projectName;
    GoogleFormViewModel googleFormViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);
        firstName=findViewById(R.id.first_name);
        lastName=findViewById(R.id.last_name);
        emialAddress=findViewById(R.id.email_adress);
        projectName=findViewById(R.id.project_link);

       googleFormViewModel=new ViewModelProvider(this).get(GoogleFormViewModel.class);
    }

    public void submitProject(View view) {
        dialogConfirm();
     }


    public void dialogConfirm(){

        final Dialog submissionSupport=new Dialog(this);
        submissionSupport.setContentView(R.layout.dialog_confirm);
        submissionSupport.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button yesButton=submissionSupport.findViewById(R.id.conf_registration);
        Button cancelButton=submissionSupport.findViewById(R.id.cancel_registration);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submissionSupport.cancel();
            }
        });
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerProject();
                submissionSupport.cancel();

            }
        });
        submissionSupport.show();

    }
    public void dialogFailure(){
        final Dialog submissionSupport=new Dialog(this);
        submissionSupport.setContentView(R.layout.dialog_faillure);
        submissionSupport.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button cancelButton=submissionSupport.findViewById(R.id.cancel_registration);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submissionSupport.cancel();
            }
        });

        submissionSupport.show();


    }
    public void dialogSuccess(){
        final Dialog submissionSupport=new Dialog(this);
        submissionSupport.setContentView(R.layout.dialog_success);
        submissionSupport.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button cancelButton=submissionSupport.findViewById(R.id.cancel_registration);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submissionSupport.cancel();
            }
        });

        submissionSupport.show();


    }
    public void registerProject(){
        googleFormViewModel.getFormResponse(
                firstName.getText().toString(),
                lastName.getText().toString(),
                emialAddress.getText().toString(),
                projectName.getText().toString()
        ).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String formResponses) {
                Toast.makeText(ProjectSubmission.this, formResponses, Toast.LENGTH_SHORT).show();
                if(formResponses.equals("Success")){
                    dialogSuccess();
                }
                else{
                    dialogFailure();
                }
            }
        });
    }
}