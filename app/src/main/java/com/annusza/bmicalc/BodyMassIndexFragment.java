package com.annusza.bmicalc;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;


public class BodyMassIndexFragment extends Fragment {

    private EditText weight;
    private EditText height;
    private TextView resultOfCalculation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_bmi, container, false);
        weight = root.findViewById(R.id.weight);
        height = root.findViewById(R.id.height);
        resultOfCalculation = root.findViewById(R.id.resultOfCalculation);
        Button calculate = root.findViewById(R.id.button_for_calculation);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBodyMassIndex();
            }
        });

        return root;
    }

    private void calculateBodyMassIndex() {

        String weightS = weight.getText().toString();
        String heihgtS = height.getText().toString();

        float weightF = Float.parseFloat(weightS);
        float heightF = Float.parseFloat(heihgtS) / 100;

        float bodyMassIndex = weightF / (heightF * heightF);

        bodyMassIndex = Math.round(bodyMassIndex);

        printBmiCalc(bodyMassIndex);
    }


    public void printBmiCalc(float bodyMassIndex) {

        String resultOfBmi;

        try {


            if (bodyMassIndex < 16.0) {

                resultOfBmi = "Starved"; // wygłodzony

            } else if (bodyMassIndex >= 16.0 && bodyMassIndex < 17) {

                resultOfBmi = "Attenuate"; // wychudzony

            } else if (bodyMassIndex >= 17.0 && bodyMassIndex < 18.5) {

                resultOfBmi = "Less than correct weight"; // niedowaga

            } else if (bodyMassIndex >= 18.5 && bodyMassIndex < 25) {

                resultOfBmi = "Correct weight"; // optimum

            } else if (bodyMassIndex >= 25.0 && bodyMassIndex < 30) {

                resultOfBmi = "Overweight"; // nadwaga

            } else if (bodyMassIndex >= 30.0 && bodyMassIndex < 35) {

                resultOfBmi = "First degree obesity"; // otyłość pierwszego stopnia

            } else if (bodyMassIndex >= 35.0 && bodyMassIndex < 40) {

                resultOfBmi = "Second degree obesity"; // otyłość drugiego stopnia

            } else {

                resultOfBmi = "Third degree obesity"; // otyłość trzeciego stopnia
            }

            String calculation = bodyMassIndex  +resultOfBmi;

            resultOfCalculation.setText(calculation);


        } catch (NumberFormatException ex) {

            resultOfCalculation.setText("Bad input");

        }
    }

}
