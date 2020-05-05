package com.annusza.bmicalc.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.annusza.bmicalc.R
import kotlinx.android.synthetic.main.fragment_bmi.*

class BodyMassIndexFragmentKot : Fragment() {

//    var weight: EditText? = null
//    var height: EditText? = null
//    var resultOfCalculation: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_bmi, container, false)
//        weight = root.findViewById(R.id.weight)
//        height = root.findViewById(R.id.height)
//        resultOfCalculation = root.findViewById(R.id.resultOfCalculation)
        val calculate = root.findViewById<Button>(R.id.button_for_calculation)
        calculate.setOnClickListener { calculateBodyMassIndex() }
        return root
    }

    private fun calculateBodyMassIndex() {

        val weightS = weight!!.text.toString()
        val heihgtS = height!!.text.toString()
        val weightF: Float = weightS.toFloat()
        val heightF: Float = heihgtS.toFloat() / 100
        var bodyMassIndex = weightF / (heightF * heightF)
        bodyMassIndex = Math.round(bodyMassIndex).toFloat()
        printBmiCalc(bodyMassIndex)
    }


    private fun printBmiCalc(bodyMassIndex: Float) {
        val resultOfBmi: String
        try {
            resultOfBmi = if (bodyMassIndex < 16.0) {
                "Starved" // wygłodzony
            } else if (bodyMassIndex >= 16.0 && bodyMassIndex < 17) {
                "Attenuate" // wychudzony
            } else if (bodyMassIndex >= 17.0 && bodyMassIndex < 18.5) {
                "Less than correct weight" // niedowaga
            } else if (bodyMassIndex >= 18.5 && bodyMassIndex < 25) {
                "Correct weight" // optimum
            } else if (bodyMassIndex >= 25.0 && bodyMassIndex < 30) {
                "Overweight" // nadwaga
            } else if (bodyMassIndex >= 30.0 && bodyMassIndex < 35) {
                "First degree obesity" // otyłość pierwszego stopnia
            } else if (bodyMassIndex >= 35.0 && bodyMassIndex < 40) {
                "Second degree obesity" // otyłość drugiego stopnia
            } else {
                "Third degree obesity" // otyłość trzeciego stopnia
            }
            val calculation = bodyMassIndex.toString() + resultOfBmi
            resultOfCalculation!!.text = calculation
        } catch (ex: NumberFormatException) {
            resultOfCalculation!!.text = "Bad input"
        }
    }

}
