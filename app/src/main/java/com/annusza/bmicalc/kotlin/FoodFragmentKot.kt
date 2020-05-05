package com.annusza.bmicalc.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.annusza.bmicalc.R
import kotlinx.android.synthetic.main.fragment_food.*

class FoodFragmentKot : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_food, container, false)
        val whatEat = view.findViewById<Button>(R.id.whatEat)
        whatEat.setOnClickListener { showRecipe() }
        return view
    }

    private fun showRecipe() {
        val S1 = bmi!!.text.toString()
        var bmiValue = 0f
        if (!S1.isEmpty()) {
            bmiValue = S1.toFloat()
        } else {
            eat!!.setText(R.string.alert)
            recipe.setText("")
            val listOfGroceries = arrayOf("")
            val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_list_item_1, listOfGroceries)
            groceries!!.adapter = adapter
        }
        if (bmiValue > 0 && bmiValue < 18.5) {
            eat!!.setText(R.string.eat1)
            recipe.setText(R.string.recipe1)
            val listOfProducts: Array<String> = getResources().getStringArray(R.array.recipeListoOfGroceries1)
            val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_list_item_1, listOfProducts)
            groceries!!.adapter = adapter
        } else if (bmiValue >= 18.5 && bmiValue <= 25) {
            eat!!.setText(R.string.eat2)
            recipe.setText(R.string.recipe2)
            val listOfProducts: Array<String> = getResources().getStringArray(R.array.recipeListoOfGroceries2)
            val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_list_item_1, listOfProducts)
            groceries!!.adapter = adapter
        } else if (bmiValue > 25) {
            eat!!.setText(R.string.eat3)
            recipe.setText(R.string.recipe3)
            val listOfProducts: Array<String> = getResources().getStringArray(R.array.recipeListoOfGroceries3)
            val adapter = ArrayAdapter(this.context!!, android.R.layout.simple_list_item_1, listOfProducts)
            groceries!!.adapter = adapter
        }
    }

}
