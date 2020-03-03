package com.annusza.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weight, height;
    TextView resultOfCalculation;
    String calculate, resultOfBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resultOfCalculation = findViewById(R.id.resultOfCalculation);
    }

    public void calculateBmi(View view) {

        String weightS = weight.getText().toString();
        String heihgtS = height.getText().toString();

        try {


            Float weightF = Float.parseFloat(weightS);
            Float heightF = Float.parseFloat(heihgtS) / 100;

            Float bodyMassIndex = weightF / (heightF * heightF);

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

            calculate = "Result: \n" + bodyMassIndex + "\n" + resultOfBmi;

            resultOfCalculation.setText(calculate);

        } catch (NumberFormatException ex) {

            resultOfCalculation.setText("Bad input");

        }
    }
}
