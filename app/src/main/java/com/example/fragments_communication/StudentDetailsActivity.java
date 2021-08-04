package com.example.fragments_communication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class StudentDetailsActivity extends AppCompatActivity implements communicationListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchStudentDetailsFragment();
    }

    private void launchStudentDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPersonalDetailsFragment fragment = new StudentPersonalDetailsFragment();
        fragmentTransaction.add(R.id.container, fragment, "personal").commit();
    }

    @Override
    public void launchPerformanceFragment(Bundle bundle) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment fragment = new StudentPerformanceDetailsFragment();
        fragment.setArguments(bundle);
        transaction.replace(R.id.container, fragment, "performanceDetailsFragment").addToBackStack("").commit();
    }
}