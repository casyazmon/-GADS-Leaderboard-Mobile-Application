package com.example.gadsleardersboard.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gadsleardersboard.R;
import com.example.gadsleardersboard.datasource.FormSubmission;
import com.example.gadsleardersboard.datasource.FormSubmissionClient;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmissionActivity extends AppCompatActivity {
    private EditText mLastName;
    private EditText mFirstName;
    private EditText mEmail;
    private EditText mProjectLink;
    private Button mSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);

        mLastName = findViewById(R.id.lastName);
        mFirstName = findViewById(R.id.firstName);
        mEmail = findViewById(R.id.email);
        mProjectLink = findViewById(R.id.linkToProject);
        mSubmitBtn = findViewById(R.id.submit);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    public void submitForm() {
        FormSubmission formSubmission = FormSubmissionClient.getRetrofitInstance().create(FormSubmission.class);
        formSubmission.submitForm(
                mEmail.getText().toString().toLowerCase(),
                mFirstName.getText().toString().toLowerCase(),
                mLastName.getText().toString().toLowerCase(),
                mProjectLink.getText().toString().toLowerCase(),
                new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, Response<Response> response) {
                        Toast.makeText(ProjectSubmissionActivity.this, "Form submitted Successfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(ProjectSubmissionActivity.this, "Error Submitting Form", Toast.LENGTH_SHORT).show();
                    }
                }

        );
    }
}