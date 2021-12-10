package com.drakkens.examen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class TrainingSeriesFragment extends ListFragment {
    private ListView listView;
    private String[] entrenaments = new String[Entrenament.entrenaments.length];

    interface Listener {
       void itemClicked(long id);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.training_series_fragment, container, false);

        for (int i = 0; i < entrenaments.length; i++) {
            entrenaments[i] = Entrenament.entrenaments[i].getNom();
        }

        listView = (ListView) view.findViewById(android.R.id.list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this.getContext(), R.layout.single_list_entry, entrenaments);
        listView.setAdapter(arrayAdapter);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView.setOnItemClickListener((parent, view1, position, id) -> ((MainActivity) getActivity()).itemClicked(id));

    }
}
