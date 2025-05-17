package com.example.tele_weather.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.tele_weather.Fragment.FuturoFragment;
import com.example.tele_weather.Fragment.LocationFragment;
import com.example.tele_weather.Fragment.PronosticoFragment;
import com.example.tele_weather.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.Locaciones) {
                loadFragment(new LocationFragment());
            } else if (id == R.id.Pronostico) {
                loadFragment(new PronosticoFragment());
            } else if (id == R.id.Futuro) {
                loadFragment(new FuturoFragment());
            }
            return true;
        });



        // Cargar el fragmento inicial
        if (savedInstanceState == null) {
            loadFragment(new LocationFragment());
        }

    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.adminhotel_container_view, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }
}