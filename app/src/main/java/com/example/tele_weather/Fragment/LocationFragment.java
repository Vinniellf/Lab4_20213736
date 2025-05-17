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

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

import com.example.tele_weather.Adapter.LocationAdapter;
import com.example.tele_weather.ApiClient;
import com.example.tele_weather.ApiService;
import com.example.tele_weather.Model.Location;
import com.example.tele_weather.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationFragment extends Fragment {
    private RecyclerView recyclerView;
    private LocationAdapter locationAdapter;
    private EditText etSearch;
    private MaterialButton btnSearch;
    private List<Location> locationList = new ArrayList<>();

    private String API_KEY = "a8c1b74e3b4646f196c55206251705";

    // API URL
    private static final String API_URL = "https://api.weatherapi.com/v1/search.json?key=ec24b1c6dd8a4d528c1205500250305&q=";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location, container, false);

        etSearch = view.findViewById(R.id.etSearch);
        btnSearch = view.findViewById(R.id.btnSearch);

        // Initialize UI components
        recyclerView = view.findViewById(R.id.recyclerLocaciones);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        locationAdapter = new LocationAdapter(locationList);
        recyclerView.setAdapter(locationAdapter);

        // Set up button click listener for search
        btnSearch.setOnClickListener(v -> searchLocation(etSearch.getText().toString()));

        return view;
    }


    public void searchLocation(String query) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<List<Location>> call = apiService.searchLocations(API_KEY, query);

        call.enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    locationList.clear();
                    locationList.addAll(response.body());
                    locationAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Respuesta inválida", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {
                return ;
            }
        });
    }
}
