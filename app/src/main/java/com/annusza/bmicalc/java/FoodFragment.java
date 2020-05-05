//package com.annusza.bmicalc.java;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import com.annusza.bmicalc.R;
//
//public class FoodFragment extends Fragment {
//
//    private EditText bmi;
//    private ListView groceries;
//    private TextView eat, recipe;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_food, container, false);
//
//        bmi = view.findViewById(R.id.bmi);
//        Button whatEat = view.findViewById(R.id.whatEat);
//        eat = view.findViewById(R.id.eat);
//        recipe = view.findViewById(R.id.recipe);
//        groceries = view.findViewById(R.id.groceries);
//
//        whatEat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showRecipe();
//            }
//        });
//
//        return view;
//    }
//
//    private void showRecipe() {
//
//        String S1 = bmi.getText().toString();
//        float bmiValue = 0;
//
//        if(!S1.isEmpty()) {
//            bmiValue = Float.parseFloat(S1);
//        } else {
//            eat.setText(R.string.alert);
//            recipe.setText("");
//            String[] listOfGroceries = {""};
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, listOfGroceries);
//            groceries.setAdapter(adapter);
//        }
//
//
//        if(bmiValue > 0 && bmiValue < 18.5) {
//            eat.setText(R.string.eat1);
//            recipe.setText(R.string.recipe1);
//            String[] listOfProducts = getResources().getStringArray(R.array.recipeListoOfGroceries1);
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, listOfProducts);
//            groceries.setAdapter(adapter);
//        } else if(bmiValue >= 18.5 && bmiValue <= 25) {
//            eat.setText(R.string.eat2);
//            recipe.setText(R.string.recipe2);
//            String[] listOfProducts = getResources().getStringArray(R.array.recipeListoOfGroceries2);
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, listOfProducts);
//            groceries.setAdapter(adapter);
//        } else if(bmiValue > 25) {
//            eat.setText(R.string.eat3);
//            recipe.setText(R.string.recipe3);
//            String[] listOfProducts = getResources().getStringArray(R.array.recipeListoOfGroceries3);
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, listOfProducts);
//            groceries.setAdapter(adapter);
//        }
//    }
//
//}
