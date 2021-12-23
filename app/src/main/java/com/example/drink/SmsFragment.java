package com.example.drink;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SmsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sms, container, false);
        EditText newNum = v.findViewById(R.id.NewNumberSms);
        Button applyBtn = v.findViewById(R.id.ApplySms);

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPhoneNum = newNum.getText().toString();
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.setPhoneNumberToSms(newPhoneNum);
            }
        });
        return  v;
    }
}