package com.example.tele_weather.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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


public class PronosticoFragment extends Fragment {
    private RecyclerView recyclerView;
    private PronosticoAdapter pronosticoAdapter;
    private EditText etSearch1, etSearch2;
    private MaterialButton btnSearch;
    private List<Pronostico> pronosticoList = new ArrayList<>();

    private String API_KEY = "a8c1b74e3b4646f196c55206251705";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pronostico, container, false);

        // Initialize UI components
        recyclerView = view.findViewById(R.id.recyclerPronosticos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        //cargarEjemplos();
        pronosticoAdapter = new PronosticoAdapter(pronosticoList, getContext());
        recyclerView.setAdapter(pronosticoAdapter);

        // Set up button click listener for search
        etSearch1 = view.findViewById(R.id.etSearch1);
        etSearch2 = view.findViewById(R.id.etSearch2);
        btnSearch = view.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(v -> searchPronostico("id:" + etSearch1.getText().toString(), etSearch2.getText().toString()));

        return view;
    }

    public void searchPronostico(String id, String dias) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<PronosticoResponse> call = apiService.getForecast(API_KEY, id, 14);

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
}