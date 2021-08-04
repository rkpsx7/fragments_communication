package com.example.fragments_communication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {
    private TextView mTvName, mTvAge, mTvGrade, mTvPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Model model = (Model) getIntent().getSerializableExtra("model");
        mTvName.setText(model.getName());
        mTvAge.setText(model.getAge()+"");
        mTvGrade.setText(model.getGrade());
        mTvPercentage.setText(model.getPercentage());
    }

    private void initViews() {
        mTvName = findViewById(R.id.tvStudentName);
        mTvAge = findViewById(R.id.tvStudentAge);
        mTvPercentage = findViewById(R.id.tvStudentPercentage);
        mTvGrade = findViewById(R.id.tvStudentGrade);
    }
}