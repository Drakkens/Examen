package com.drakkens.examen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TrainingInfoFragment extends Fragment {
    private long programId;

    private TextView text1, text2;


    public void setProgramId(long id) {
        this.programId = id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.training_info_fragment, container, false);

        text1 = view.findViewById(R.id.text1);
        text2 = view.findViewById(R.id.text2);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        text1.setText(Entrenament.entrenaments[Math.toIntExact(programId)].getNom());
        text2.setText(Entrenament.entrenaments[Math.toIntExact(programId)].getDescripcio());
    }
}
