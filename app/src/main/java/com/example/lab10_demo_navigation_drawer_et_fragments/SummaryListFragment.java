package com.example.lab10_demo_navigation_drawer_et_fragments;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class SummaryListFragment extends ListFragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] dataItems = {
                "Donnée 1", "Donnée 2", "Donnée 3", "Donnée 4",
                "Donnée 5", "Donnée 6", "Donnée 7", "Donnée 8",
                "Donnée 9", "Donnée 10"
        };

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                dataItems
        );
        setListAdapter(listAdapter);
    }
}