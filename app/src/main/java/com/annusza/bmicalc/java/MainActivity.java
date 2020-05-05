//package com.annusza.bmicalc.java;
//
//import android.os.Bundle;
//import android.view.MenuItem;
//
//import androidx.annotation.NonNull;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//import com.annusza.bmicalc.R;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class MainActivity extends AppCompatActivity {

//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//        bottomNav.setOnNavigationItemSelectedListener(navigationListener);
//
//        //
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                    new StartFragment()).commit();
//        }
//    }
//
//    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    Fragment selectedFragment = null;
//
//                    switch (item.getItemId()) {
////                        case R.id.homeNav:
////                            selectedFragment = new HomeFragment();
////                            break;
//                        case R.id.bmiNav:
//                            selectedFragment = new BodyMassIndexFragment();
//                            break;
//                        case R.id.caloriesNav:
//                            selectedFragment = new CalFragment();
//                            break;
//                        case R.id.foodNav:
//                            selectedFragment = new FoodFragment();
//                            break;
//                        case R.id.quizNav:
//                            selectedFragment = new QuizFragment();
//                            break;
//                        case R.id.statNav:
//                            selectedFragment = new StatisticFragment();
//                    }
//
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                            selectedFragment).commit();
//
//                    return true;
//                }
//            };
//
//}
