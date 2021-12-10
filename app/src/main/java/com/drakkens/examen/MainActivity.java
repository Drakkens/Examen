package com.drakkens.examen;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements TrainingSeriesFragment.Listener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void itemClicked(long id) {

        Intent intent = new Intent(this, TrainingInfoActivity.class);
        intent.putExtra("ID", id);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            startActivity(intent);

        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer2);
            fragmentManager.beginTransaction().remove(fragment).commit();

            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainer2, TrainingInfoFragment.class, null, "Info Fragment").commit();

            fragmentManager.executePendingTransactions();
            TrainingInfoFragment trainingInfoFragment = (TrainingInfoFragment) fragmentManager.findFragmentByTag("Info Fragment");
            trainingInfoFragment.setProgramId(id);
        }
    }

}
