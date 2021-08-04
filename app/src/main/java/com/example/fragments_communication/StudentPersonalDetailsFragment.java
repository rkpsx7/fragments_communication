package com.example.fragments_communication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentPersonalDetailsFragment extends Fragment {

    private Button mBtnNext;
    private EditText mEtName, mEtAge;
    private communicationListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_personal_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (communicationListener) context;
    }

    private void initViews(View view) {
        mBtnNext = view.findViewById(R.id.btnNext);
        mEtName = view.findViewById(R.id.etStudentName);
        mEtAge = view.findViewById(R.id.etStudentAge);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mEtName.getText().toString();
                int age = Integer.parseInt(mEtAge.getText().toString());
                if (listener != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("name", name);
                    bundle.putInt("age", age);
                    listener.launchPerformanceFragment(bundle);
                }
            }
        });
    }


}