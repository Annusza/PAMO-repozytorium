package com.annusza.bmicalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CalFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private String sexText;
    private EditText weight;
    private EditText height;
    private EditText age;
    private TextView result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cal, container, false);

        weight = view.findViewById(R.id.weight);
        height = view.findViewById(R.id.height);
        age = view.findViewById(R.id.age);
        result = view.findViewById(R.id.resultOfCalculation);
        Spinner sex = view.findViewById(R.id.sex);

        ArrayAdapter<CharSequence> arrayAdapter;
        arrayAdapter = ArrayAdapter.createFromResource(this.getContext(), R.array.sexToList, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sex.setAdapter(arrayAdapter);
        sex.setOnItemSelectedListener(this);

        Button calculate = view.findViewById(R.id.button_for_calculation);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCaloriesPerDay();
            }
        });
        return view;
    }

    private void calculateCaloriesPerDay() {

        String weightS = weight.getText().toString();
        String heightS = height.getText().toString();
        String ageS = age.getText().toString();
        String sexS = getString(R.string.sexW);

        double weightValue = Double.parseDouble(weightS);
        double heightValue = Double.parseDouble(heightS);
        double ageValue = Double.parseDouble(ageS);
        double cpd;

        if(sexText.equals(sexS)) {
            cpd = 655.1 + (9.567 * weightValue) + (1.85 * heightValue) - (4.68 * ageValue);
        } else {
            cpd = 66.47 + (13.7 * weightValue) + (5.0 * heightValue) - (6.76 * ageValue);
        }

        cpd = Math.round(cpd);
        String calories = cpd + " kcal";
        result.setText(calories);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        sexText = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), sexText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}