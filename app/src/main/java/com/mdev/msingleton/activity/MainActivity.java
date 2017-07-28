package com.mdev.msingleton.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mdev.msingleton.R;
import com.mdev.msingleton.fragment.TableBallFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framHome, TableBallFragment.newInstance(),"TEBLEBALL")
                .commit();
    }
}
