package com.dvilson.gadsleaderboard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dvilson.gadsleaderboard.models.Project;
import com.dvilson.gadsleaderboard.services.ProjectService;
import com.dvilson.gadsleaderboard.services.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText firstName,lastName, emailAddress,projectLink;
    Button submit;
    private static final String URL ="https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl\n" +
            "35cwZr2xyjIhaMAz8WChQ/formResponse";
    private static final String TAG = "SubmissionActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        firstName =(EditText)findViewById(R.id.activity_submission_edit_first_name);
        lastName = (EditText)findViewById(R.id.activity_submission_edit_last_name);
        emailAddress = (EditText)findViewById(R.id.activity_submission_edit_email_address);
        projectLink = (EditText)findViewById(R.id.activity_submission_edit_project_link);
        submit = (Button)findViewById(R.id.activity_submission_btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(TextUtils.isEmpty(firstName.getText().toString().trim())){

                   firstName.setError("Please enter your first name");
               }
               if(TextUtils.isEmpty(lastName.getText().toString().trim())){
                   lastName.setError("Please enter your last name");
               }
               if(TextUtils.isEmpty(emailAddress.getText().toString().trim())){
                   emailAddress.setError("Please enter your email address");
               }
               if(TextUtils.isEmpty(projectLink.getText().toString().trim())){
                   projectLink.setError("Please enter the project link on GITHUB");
               }else{
                   confirmationDialog();
               }
            }
        });

        configureToolbar();
    }

    private void confirmationDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_confirmation,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(false);

        AlertDialog dialog = builder.create();
        view.findViewById(R.id.alert_dialog_confirmation_img_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        view.findViewById(R.id.alert_dialog_confirmation_btn_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitProject();
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void successfulDialog(){

        View view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_successful,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void onFailureDialog(){

        View view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_faillure,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();

    }


    public void configureToolbar(){

        toolbar = findViewById(R.id.activity_submission_toolbar);
        setSupportActionBar(toolbar);
        ActionBar  ab = getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);


    }

    private void submitProject(){

        ProjectService taskService = ServiceBuilder.buildService(ProjectService.class);
        Call<Void> call = taskService.submitProject(URL,
                firstName.getText().toString().trim(),
                lastName.getText().toString().trim(),
                emailAddress.getText().toString().trim(),
                projectLink.getText().toString().trim());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "onResponse: "+response.code());
               if(response.isSuccessful()){
                   Log.d(TAG, "onResponse: "+response.code());
                   successfulDialog();


               }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
                onFailureDialog();

            }
        });
    }


}
