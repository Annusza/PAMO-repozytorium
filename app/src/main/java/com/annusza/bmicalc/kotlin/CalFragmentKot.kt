package com.annusza.bmicalc.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.annusza.bmicalc.R
import android.widget.AdapterView.OnItemSelectedListener
import kotlinx.android.synthetic.main.fragment_cal.*

class CalFragmentKot : Fragment(), OnItemSelectedListener {

    var sexText: String? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cal, container, false)
//        weight = view.findViewById(R.id.weight)
//        height = view.findViewById(R.id.height)
//        age = view.findViewById(R.id.age)
//        result = view.findViewById(R.id.resultOfCalculation)
        val sex = view.findViewById<Spinner>(R.id.sex)
        val arrayAdapter: ArrayAdapter<CharSequence>
        arrayAdapter = ArrayAdapter.createFromResource(this.context!!, R.array.sexToList, android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sex.adapter = arrayAdapter
        sex.onItemSelectedListener = this
        val calculate = view.findViewById<Button>(R.id.button_for_calculation)
        calculate.setOnClickListener { calculateCaloriesPerDay() }
        return view
    }

    private fun calculateCaloriesPerDay() {

        if(weight.text.isNullOrEmpty()||height.text.isNullOrEmpty()||age.text.isNullOrEmpty()){
            resultOfCalculation!!.setTextSize(1, 20F)
            resultOfCalculation!!.text=getString(R.string.heigt_weight_age)
        } else{
            val weightS = weight!!.text.toString()
            val heightS = height!!.text.toString()
            val ageS = age!!.text.toString()
            val sexS: String = getString(R.string.sexW)
            val weightValue = weightS.toDouble()
            val heightValue = heightS.toDouble()
            val ageValue = ageS.toDouble()
            var cpd: Double
            cpd = if (sexText == sexS) {
                655.1 + 9.567 * weightValue + 1.85 * heightValue - 4.68 * ageValue
            } else {
                66.47 + 13.7 * weightValue + 5.0 * heightValue - 6.76 * ageValue
            }
            cpd = Math.round(cpd).toDouble()
            val calories = "$cpd kcal"
            resultOfCalculation!!.text = calories
        }


    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        sexText = parent.getItemAtPosition(position).toString()
        Toast.makeText(parent.context, sexText, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

}
