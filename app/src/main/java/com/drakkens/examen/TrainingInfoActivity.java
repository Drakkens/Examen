package com.drakkens.examen;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

public class TrainingInfoActivity extends AppCompatActivity {
    Long id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_info);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            id = getIntent().getExtras().getLong("ID");

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainer, TrainingInfoFragment.class, null, "Info Fragment").commit();

            fragmentManager.executePendingTransactions();
            TrainingInfoFragment trainingInfoFragment = (TrainingInfoFragment) fragmentManager.findFragmentByTag("Info Fragment");
            trainingInfoFragment.setProgramId(id);

        }
    }
}
