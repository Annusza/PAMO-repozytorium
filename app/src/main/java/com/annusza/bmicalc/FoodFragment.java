package com.annusza.bmicalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FoodFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food, container, false);

        ListView groceries = view.findViewById(R.id.groceries);
        String[] listOfGroceries = getResources().getStringArray(R.array.recipeListoOfGroceries);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, listOfGroceries);

        groceries.setAdapter(arrayAdapter);

        return view;
    }

}
