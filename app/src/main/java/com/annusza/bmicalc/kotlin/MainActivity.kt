package com.annusza.bmicalc.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.annusza.bmicalc.R
import com.annusza.bmicalc.java.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navigationListener)

        //
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    StartFragmentKot()).commit()
        }
    }

    private val navigationListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.bmiNav -> selectedFragment = BodyMassIndexFragmentKot()
            R.id.caloriesNav -> selectedFragment = CalFragmentKot()
            R.id.foodNav -> selectedFragment = FoodFragmentKot()
            R.id.quizNav -> selectedFragment = QuizFragmentKot()
            R.id.statNav -> selectedFragment = StatisticFragmentKot()
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                selectedFragment!!).commit()
        true
    }

}