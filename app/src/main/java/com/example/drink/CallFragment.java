package com.example.drink;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CallFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_call, container, false);
        EditText newNum = v.findViewById(R.id.newNum);
        Button applyBtn = v.findViewById(R.id.setNum);

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           String newPhoneNum = "tel:"+newNum.getText().toString();
           MainActivity mainActivity = (MainActivity) getActivity();
           mainActivity.setPhoneNumber(newPhoneNum);

            }
        });

        return v;
    }
}