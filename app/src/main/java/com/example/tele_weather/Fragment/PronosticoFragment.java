package com.example.tele_weather.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tele_weather.Adapter.PronosticoAdapter;
import com.example.tele_weather.ApiClient;
import com.example.tele_weather.ApiService;
import com.example.tele_weather.Model.Pronostico;
import com.example.tele_weather.PronosticoResponse;
import com.example.tele_weather.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PronosticoFragment extends Fragment implements SensorEventListener {
    private RecyclerView recyclerView;
    private PronosticoAdapter pronosticoAdapter;
    private EditText etSearch1, etSearch2;
    private MaterialButton btnSearch;
    private List<Pronostico> pronosticoList = new ArrayList<>();

    private String API_KEY = "a8c1b74e3b4646f196c55206251705";

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private long lastShakeTime = 0;
    private static final float SHAKE_THRESHOLD = 20.0f;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pronostico, container, false);
        etSearch1 = view.findViewById(R.id.etSearch1);
        etSearch2 = view.findViewById(R.id.etSearch2);
        btnSearch = view.findViewById(R.id.btnSearch);

        recyclerView = view.findViewById(R.id.recyclerPronosticos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        pronosticoAdapter = new PronosticoAdapter(pronosticoList, getContext());
        recyclerView.setAdapter(pronosticoAdapter);

        btnSearch.setOnClickListener(v -> buscarPronostico(etSearch1.getText().toString(), etSearch2.getText().toString()));

        String id = getArguments() != null ? getArguments().getString("locationId") : null;
        if (id != null) {
            buscarPronostico(id, "14");
            etSearch1.setVisibility(View.GONE);
            etSearch2.setVisibility(View.GONE);
            btnSearch.setVisibility(View.GONE);
        }

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

        return view;
    }

    //Esta parte se hizo con IA
    public void buscarPronostico(String id, String dias) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<PronosticoResponse> call = apiService.getForecast(API_KEY, "id:" + id, 14);

        call.enqueue(new Callback<PronosticoResponse>() {
            @Override
            public void onResponse(Call<PronosticoResponse> call, Response<PronosticoResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    pronosticoList.clear();
                    pronosticoList.addAll(response.body().getForecast().getForecastday());
                    pronosticoAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Respuesta inválida", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PronosticoResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (sensorManager != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            double acceleration = Math.sqrt(x * x + y * y + z * z) - SensorManager.GRAVITY_EARTH;
            long currentTime = System.currentTimeMillis();

            if (acceleration > SHAKE_THRESHOLD && currentTime - lastShakeTime > 1000) {
                lastShakeTime = currentTime;
                showConfirmationDialog();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    private void showConfirmationDialog() {
        new AlertDialog.Builder(getContext())
                .setTitle("Confirmar eliminación")
                .setMessage("¿Deseas eliminar los últimos pronósticos obtenidos?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    pronosticoList.clear();
                    pronosticoAdapter.notifyDataSetChanged();
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }
}
