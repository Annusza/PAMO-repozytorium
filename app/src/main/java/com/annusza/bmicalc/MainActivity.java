package com.annusza.bmicalc;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navigationListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new StartFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.startNav:
                            selectedFragment = new StartFragment();
                            break;
                        case R.id.bmiNav:
                            selectedFragment = new BodyMassIndexFragment();
                            break;
                        case R.id.caloriesNav:
                            selectedFragment = new CalFragment();
                            break;
                        case R.id.foodNav:
                            selectedFragment = new FoodFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

}
//    EditText weight, height;
//    TextView resultOfCalculation;
//    String calculate, resultOfBmi;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        weight = findViewById(R.id.weight);
//        height = findViewById(R.id.height);
//        resultOfCalculation = findViewById(R.id.resultOfCalculation);
//    }
//
//    public void calculateBmi(View view) {
//
//        String weightS = weight.getText().toString();
//        String heihgtS = height.getText().toString();
//
//        Float weightF = Float.parseFloat(weightS);
//        Float heightF = Float.parseFloat(heihgtS) / 100;
//
//        Float bodyMassIndex = weightF / (heightF * heightF);
//
//        try {
//
//
//            if (bodyMassIndex < 16.0) {
//
//                resultOfBmi = "Starved"; // wygłodzony
//
//            } else if (bodyMassIndex >= 16.0 && bodyMassIndex < 17) {
//
//                resultOfBmi = "Attenuate"; // wychudzony
//
//            } else if (bodyMassIndex >= 17.0 && bodyMassIndex < 18.5) {
//
//                resultOfBmi = "Less than correct weight"; // niedowaga
//
//            } else if (bodyMassIndex >= 18.5 && bodyMassIndex < 25) {
//
//                resultOfBmi = "Correct weight"; // optimum
//
//            } else if (bodyMassIndex >= 25.0 && bodyMassIndex < 30) {
//
//                resultOfBmi = "Overweight"; // nadwaga
//
//            } else if (bodyMassIndex >= 30.0 && bodyMassIndex < 35) {
//
//                resultOfBmi = "First degree obesity"; // otyłość pierwszego stopnia
//
//            } else if (bodyMassIndex >= 35.0 && bodyMassIndex < 40) {
//
//                resultOfBmi = "Second degree obesity"; // otyłość drugiego stopnia
//
//            } else {
//
//                resultOfBmi = "Third degree obesity"; // otyłość trzeciego stopnia
//            }
//
//            calculate = "Result: \n" + bodyMassIndex + "\n" + resultOfBmi;
//
//            resultOfCalculation.setText(calculate);
//
//
//        } catch (NumberFormatException ex) {
//
//            resultOfCalculation.setText("Bad input");
//
//        }
//    }

