package com.example.btqhm;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragment extends Fragment {
     Spinner spinner;


    public IncomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_income, container, false);

        spinner = view.findViewById(R.id.incomeTypeSpinner);

        final ArrayList<String> IncomeTypeList =new ArrayList<>();

        IncomeTypeList.add("Admission");
        IncomeTypeList.add("Tution Fee");
        IncomeTypeList.add("Boarding Fee");
        IncomeTypeList.add("Exame Fee");
        IncomeTypeList.add("Donates");
        IncomeTypeList.add("Mahfil");
        IncomeTypeList.add("Tour");
        IncomeTypeList.add("Others");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,IncomeTypeList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Sumon", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        return view;
    }

}
