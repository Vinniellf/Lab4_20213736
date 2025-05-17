package com.example.tele_weather;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.provider.Settings;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tele_weather.Activity.AppActivity;
import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    MaterialButton bottom_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottom_start = findViewById(R.id.button_start);
        bottom_start.setOnClickListener(view -> {
            if (comprobarConexion()) {
                startActivity(new Intent(MainActivity.this, AppActivity.class));
            } else {
                mostrarDialogoSinInternet();}
        });


    }
    //Aquí también lo hice con IA
    private boolean comprobarConexion() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm != null) {
            Network network = cm.getActiveNetwork();

            if (network != null) {
                NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);

                if (capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void mostrarDialogoSinInternet() {
        new AlertDialog.Builder(this)
                .setTitle("Sin conexión")
                .setMessage("No hay conexión a Internet. Por favor, actívela.")
                .setPositiveButton("Configuración", (dialog, which) -> {
                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                })
                .setCancelable(false)
                .show();
    }

}